package lotto.service;

import java.util.Map;
import java.util.Objects;
import lotto.domain.IssuedLotto;
import lotto.domain.Rank;
import lotto.domain.WinLotto;

public class StatisticsServiceImpl implements StatisticsService {

    @Override
    public void compileStatistics(IssuedLotto issuedLotto, WinLotto winLotto) {

    }

    private Map<Rank, Integer> compile(IssuedLotto issuedLotto, WinLotto winLotto, int bonusNumber) {
        Map<Rank, Integer> statResult = Rank.getAllGrades();

        // issuedLotto.getLotto()
        //            .stream()
        //            .map(lotto -> lotto.getLottoResult(winningNumber.getNumbers(), bonusNumber.getNumber()))
        //            .map(lottoResult -> Grade.getGrade(lottoResult.getCorrectCount(), lottoResult.isHavingBonusNumber()))
        //            .filter(Objects::nonNull)
        //            .forEach(grade -> statResult.put(grade, statResult.get(grade) + 1));

        return statResult;
    }

}
