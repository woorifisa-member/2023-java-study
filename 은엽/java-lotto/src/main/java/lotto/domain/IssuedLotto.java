package lotto.domain;

import java.util.List;

public class IssuedLotto {
    private final List<Lotto> lottos;

    public IssuedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}