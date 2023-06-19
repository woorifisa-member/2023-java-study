package lotto.service;

import lotto.domain.*;

public class StatisticsServiceImpl implements StatisticsService {

    private double returnRate;

    @Override
    public void compileStatistics(long userPrice) {
        long totalPrize = calculateTotalPrize();
        returnRate = ((double) totalPrize / (double) userPrice) * 100;
    }

    private long calculateTotalPrize() {
        Rank[] ranks = Rank.values();
        int[] results = LottoResult.getResult();
        int totalPrize = 0;
        for (int i = 0; i < results.length; i++) {
            if (results[i] > 0) {
                totalPrize += ranks[i].getPrizeMoney() * results[i];
            }
        }
        return totalPrize;
    }

    @Override
    public String toString() {
        return String.format("총 수익률은 %.1f%s입니다.", returnRate,"%");
    }
}
