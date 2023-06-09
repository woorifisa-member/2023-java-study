package lotto.io;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public final class Writer {

    private static final BufferedWriter bw;

    static {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private Writer() {

    }

    public static void print(String s) {
        write(s, false);
    }

    public static void print(Object o) {
        print(o.toString());
    }

    public static void println(String s) {
        write(s, true);
    }

    public static void println(Object o) {
        println(o.toString());
    }

    private static void write(String s, boolean newLine) {
        try {
            bw.write(s);
            if (newLine) {
                bw.write("\n");
            }
            bw.flush();
        } catch (IOException ignore) {

        }
    }

    public static void printMyLottoList(IssuedLotto issuedLotto) {
        List<Lotto> lottos = issuedLotto.getLottoList();
        write(lottos.size() + "개를 구매했습니다.", true);
        for (Lotto lotto : lottos) {
            write(lotto.getNumString(), true);
        }

    }

    public static void printLottoResult(Integer purchaseAmount, Map<Rank, Integer> map) {
        write("당첨 통계", true);
        write("---", true);
        double profitSum = 0;
        for (Map.Entry<Rank, Integer> entry : map.entrySet()) {
            Rank rank = entry.getKey();
            if (entry.getValue() > 0) {
                profitSum += rank.getPrizeMoney();
            }
            write(rank.getMessage(entry.getValue()), true);
        }
        double rateProfit = (profitSum / purchaseAmount) * 100;
        write("총 수익률은 " + rateProfit + "%입니다.", true);


    }
}
