package lotto.domain;

import java.util.List;

public class IssuedLotto {

    private final List<Lotto> lotto;

    public List<Lotto> getLotto() {
        return lotto;
    }

    public IssuedLotto(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.lotto.size(); i++){
            stringBuilder.append(this.lotto.get(i));
            if (i < this.lotto.size() - 1){
                stringBuilder.append("\n");
            }
        }
        return String.valueOf(stringBuilder);
    }
}
