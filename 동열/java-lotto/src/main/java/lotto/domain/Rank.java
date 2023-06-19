package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public enum Rank {

    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    private static final Map<Rank, Integer> ranks;
    private static final DecimalFormat formatter;

    private final int count;
    private final int prizeMoney;

    Rank(int count, int prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    static {
        formatter = new DecimalFormat("###,###");
        ranks = new TreeMap<>(Comparator.comparing(Rank::getPrizeMoney));

        Arrays.stream(Rank.values())
              .forEach(rank -> ranks.put(rank, 0));
    }

    public static Map<Rank, Integer> getAllGrades() {
        return ranks;
    }

    public static Rank getRank(int count, boolean haveBonusNumber) {
        if (count == 5 && haveBonusNumber) {
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                     .filter(rank -> rank != SECOND)
                     .filter(rank -> rank.count == count)
                     .findFirst()
                     .orElse(null);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", count, format(prizeMoney));
        }
        return String.format("%d개 일치 (%s원)", count, format(prizeMoney));
    }

    private String format(int prizeMoney) {
        return formatter.format(prizeMoney);
    }

}
