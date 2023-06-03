package lotto.domain;

import lotto.io.Writer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class IssuedLotto {

    private final List<Lotto> lotto;

    public IssuedLotto(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.lotto.size(); i++){
            str += this.lotto.get(i);
            if (i < this.lotto.size() - 1){
                str += "\n";
            }
        }
        return str;
    }
}
