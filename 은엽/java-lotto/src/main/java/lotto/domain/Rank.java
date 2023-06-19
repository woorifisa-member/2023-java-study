package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int prize;

    Rank(int countOfMatch, int prize) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount(List<Lotto> lottos) {
        int count = 0;
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto);
            if (matchCount == countOfMatch) {
                count++;
            }
        }
        return count;
    }

    private int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (containsNumber(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean containsNumber(int number) {
        return Arrays.asList(getNumbers()).contains(number);
    }

    private Integer[] getNumbers() {
        return Arrays.stream(values())
                .filter(rank -> rank != MISS)
                .map(rank -> rank.countOfMatch)
                .toArray(Integer[]::new);
    }

    public static Rank valueOf(int countOfMatch, boolean hasBonusNumber) {
        if (countOfMatch == 6) {
            return FIRST;
        }
        if (countOfMatch == 5) {
            if (hasBonusNumber) {
                return SECOND;
            }
            return THIRD;
        }
        if (countOfMatch == 4) {
            return FOURTH;
        }
        if (countOfMatch == 3) {
            return FIFTH;
        }
        return MISS;
    }
}