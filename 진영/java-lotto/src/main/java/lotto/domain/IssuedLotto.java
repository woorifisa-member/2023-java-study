package lotto.domain;

import java.util.List;

public class IssuedLotto {

    private final List<Lotto> lotto;

    public IssuedLotto(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public List<Lotto> getLottoList() {
        return lotto;
    }

    public Lotto getLottoByIndex(int index) {
        return lotto.get(index);
    }

    public int getLottoCount() {
        return lotto.size();
    }

}
