package lotto.service;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.io.Writer;


public class CompareLotto implements StatisticsService{

    // 당첨 로또와 비교
    // winLotto 에는 numbers, bonusNumber 있음
    public void compileStatistics(IssuedLotto issuedLotto, WinLotto winLotto){
        int result[] = new int[5];
        for (Lotto oneLotto:issuedLotto.lotto){
            int sameCount = 0;
            boolean sameBonus = false;
            for (int numIssued:oneLotto.numbers){
                if (numIssued == winLotto.bonusNumber){
                    sameBonus = true;
                }
                // winLotto.WinLotto.numbers 구조 확인
                for (int numWin:winLotto.WinLotto.numbers) {
                    if (numIssued == numWin) {
                        sameCount += 1;
                    }
                }
            }
            if (sameCount==3){
                result[0] += 1;
            } else if (sameCount==4) {
                result[1] += 1;
            } else if (sameCount==5 && sameBonus==false) {
                result[2] += 1;
            } else if (sameCount==5 && sameBonus==true) {
                result[3] += 1;
            } else if (sameCount==6) {
                result[4] += 1;
            }
        }
        Writer.print("3개 일치 (5,000원) - ");
        Writer.print(result[0]);
        Writer.println("개");
        Writer.print("4개 일치 (50,000원) - ");
        Writer.print(result[1]);
        Writer.println("개");
        Writer.print("5개 일치 (1,500,000원) - ");
        Writer.print(result[2]);
        Writer.println("개");
        Writer.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        Writer.print(result[3]);
        Writer.println("개");
        Writer.print("6개 일치 (2,000,000,000원) - ");
        Writer.print(result[4]);
        Writer.println("개");
        Writer.print("총 수익률은 ");
        long earned = 0;
        earned += (result[0]*5_000 + result[1]*50_000 + result[2]*1_500_000 + result[3]*30_000_000 + result[4]*2_000_000_000);
        // TODO 총 수익률 계산하고 출력 (price 어떻게 가져오지..?)
    }

}
