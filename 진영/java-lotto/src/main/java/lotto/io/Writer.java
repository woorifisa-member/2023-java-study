package lotto.io;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
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

    public static void printMyLottoList(IssuedLotto issuedLotto){
        List<Lotto> lottos = issuedLotto.getLottoList();
            write(lottos.size()+"개를 구매했습니다.",true);
        for(Lotto lotto : lottos){
            write(lotto.getNumString(),true);
        }


    }

}
