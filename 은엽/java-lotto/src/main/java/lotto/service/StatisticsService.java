package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatisticsService {
    public Rank calculateRank(List<Lotto> lottos, WinLotto winLotto) {
        Rank rank = Rank.MISS;
        Set<Integer> winningNumbers = new HashSet<>(winLotto.getNumbers());
        int countOfMatch = 0;
        boolean hasBonusNumber = false;

        for (Lotto lotto : lottos) {
            for (int number : lotto.getNumbers()) {
                if (winningNumbers.contains(number)) {
                    countOfMatch++;
                }
            }

            if (countOfMatch == 5 && lotto.getNumbers().contains(winLotto.getBonusNumber())) {
                hasBonusNumber = true;
            }

            rank = Rank.valueOf(countOfMatch, hasBonusNumber);
        }

        return rank;
    }
}