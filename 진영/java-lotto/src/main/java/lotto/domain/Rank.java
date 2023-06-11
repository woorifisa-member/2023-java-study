package lotto.domain;

import java.util.stream.IntStream;

public enum Rank {

    // TODO: Emum 활용하기

    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    ;
    private final int count;
    private final boolean bonus;
    private final int prizeMoney;
    private final String message;

    Rank(int count, boolean isBonus, int prizeMoney, String message) {
        this.count = count;
        this.bonus = isBonus;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static Rank getRank(Lotto lotto, WinLotto winLotto) {
        int count = (int) IntStream.range(0, 6)
                .filter(i -> winLotto.contains(lotto.getNumberByIndex(i)))
                .count();

        boolean isBonus = IntStream.range(0, 6)
                .anyMatch(i -> lotto.getNumberByIndex(i) == winLotto.getBonus());

        return loadingRank(count, isBonus);
    }

    public static Rank loadingRank(int matchedCount, boolean isBonus) {
        for (Rank rank : values()) {
            if (rank.count == matchedCount && rank.bonus == isBonus) {
                return rank;
            }
        }
        return null;
    }

    public String getMessage(int count) {
        return String.format(message, count);
    }

    public double getPrizeMoney(){
        return (double) this.prizeMoney;
    }

}
