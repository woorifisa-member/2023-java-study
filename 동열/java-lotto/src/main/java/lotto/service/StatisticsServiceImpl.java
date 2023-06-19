package lotto.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.WinLotto;
import lotto.domain.WinResult;

public class StatisticsServiceImpl implements StatisticsService {

    @Override
    public WinResult compileStatistics(IssuedLotto issuedLotto, WinLotto winLotto) {

        return new WinResult(issuedLotto.getLotto().size(), compile(issuedLotto, winLotto));
    }

    private Map<Rank, Integer> compile(IssuedLotto issuedLotto, WinLotto winLotto) {
        Map<Rank, Integer> statResult = Rank.getAllGrades();

        issuedLotto.getLotto()
                   .stream()
                   .map(lotto -> this.getResult(lotto, winLotto))
            // .map(new Function<Lotto, Object>() {
            //     @Override
            //     public Object apply(Lotto lotto) {
            //         return null;
            //     }
            // })
                   .map(lottoResult -> Rank.getRank(lottoResult.getCorrectCount(), lottoResult.isHavingBonusNumber()))
                   .filter(Objects::nonNull)
                   .forEach(rank -> statResult.put(rank, statResult.get(rank) + 1));

        return statResult;
    }

    private LottoResult getResult(Lotto issuedLotto, WinLotto winLotto) {
        Set<Integer> winNumbers = new HashSet<>(winLotto.getNumbers());
        int correctCount = 0;
        boolean havingBonusNumber = false;

        for (int number : issuedLotto.getNumbers()) {
            if (winNumbers.contains(number)) {
                correctCount++;
                continue;
            }

            if (number == winLotto.getBonusNumber()) {
                havingBonusNumber = true;
            }
        }

        return new LottoResult(correctCount, havingBonusNumber);
    }

}
