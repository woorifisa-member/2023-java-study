package lotto.domain;

import java.util.List;

public class IssuedLotto {

    // LottoGame에서 출력시 접근하려고 public으로 변경
    public final List<Lotto> lotto;

    // 생성자
    public IssuedLotto(List<Lotto> lotto) {this.lotto = lotto;}
}