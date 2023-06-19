package lotto.domain;

public class WinLotto {

    // 둘 다 public으로 변경
    public final Lotto WinLotto;
    public final int bonusNumber;

    public WinLotto(Lotto winLotto, int bonusNumber) {
        WinLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

}
