package lotto.service;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinLotto;
import lotto.io.Writer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class HelloStatisticsServiceImpl implements StatisticsService {
    DecimalFormat decFormat = new DecimalFormat("###,###");

    public static int count = 0;
    public static int[] counts = new int[5];
    @Override
    public void compileStatistics(IssuedLotto issuedLotto, WinLotto winLotto) {
        List<Integer> winNumbers = winLotto.getWinLotto().getNumbers();
        int winBonusNumber = winLotto.getBonusNumber();

        // issuedLotto의 타입은 IssuedLotto이고, List<Lotto> 자료형인 lotto 변수를 가져와야함! 프라이빗이니까 게터로..
        for (Lotto lotto : issuedLotto.getLotto()){

            count = 0;
            List<Integer> numbers = lotto.getNumbers();
            count = matchNumber(numbers, winNumbers, winBonusNumber);
            if(count > 2){
                counts[count-3] += 1;
            }

        }


        statistics(issuedLotto);

    }

    private int matchNumber(List numbers, List winNumbers, int winBonusNumber){
        for (int i = 0; i < numbers.size(); i++){
            if(winNumbers.contains(numbers.get(i))){
                count ++;
            }
        }

        if (count == 6) count++;

        if (count == 5){
            if(numbers.contains(winBonusNumber)) {
                count++;
            }
        }
        return count;
    }

    public void statistics(IssuedLotto issuedLotto){
        int i = 0;
        int total = 0;

        Writer.println("\n당첨 통계\n---");
        for(Rank rank: Rank.values()){
            Writer.print(rank.getCount()+"개 일치");
            if(rank == Rank.SECOND){
                Writer.print(", 보너스 볼 일치");
            }
            Writer.print(" ("+decFormat.format(rank.getPrizeMoney())+"원) - ");
            Writer.println(counts[i]+"개");

            if(counts[i] > 0){
                total += counts[i] * rank.getPrizeMoney();
            }

            i++;
        }

        Writer.println("총 수익률은 "+ total/issuedLotto.getLotto().size()*0.1 +"%입니다.");


    }
}
