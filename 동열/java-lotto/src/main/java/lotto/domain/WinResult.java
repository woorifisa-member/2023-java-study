package lotto.domain;

import java.util.Map;

public class WinResult {

    private final Map<Rank, Integer> result;
    private final double rateOfReturn;
    private final long input;
    private final long output;

    public WinResult(long input, Map<Rank, Integer> result) {
        this.input = input;
        this.result = result;
        this.output = calculateOutput(result);
        this.rateOfReturn = calculateRate();
    }

    private long calculateOutput(Map<Rank, Integer> result) {
        long totalPrize = 0;

        for (Map.Entry<Rank, Integer> rank : result.entrySet()) {
            totalPrize += ((long) rank.getKey().getPrizeMoney() * rank.getValue());
        }

        return totalPrize;
    }

    private double calculateRate() {
        double rate = ((double) output / input) * 100;
        return Math.round(rate * 10.0) / 10.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Rank, Integer> Rank : result.entrySet()) {
            sb.append(Rank.getKey())
              .append(" - ")
              .append(Rank.getValue())
              .append("개")
              .append('\n');
        }

        sb.append(String.format("촐 수익률은 %f.1%%입니다.", rateOfReturn));

        return sb.toString();
    }

}
