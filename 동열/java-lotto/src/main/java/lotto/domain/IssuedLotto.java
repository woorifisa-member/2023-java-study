package lotto.domain;

import java.util.List;

public class IssuedLotto {

    private final List<Lotto> lotto;

    public IssuedLotto(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(lotto.size())
          .append("개를 구매했습니다.\n");

        lotto.forEach(l -> sb.append(l).append("\n"));

        return sb.toString();
    }
}
