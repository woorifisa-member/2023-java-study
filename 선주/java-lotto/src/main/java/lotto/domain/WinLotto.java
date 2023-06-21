package lotto.domain;

public class WinLotto {

    private final Lotto WinLotto;
    private final int bonusNumber;

    public Lotto getWinLotto() {
        return WinLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public WinLotto(Lotto winLotto, int bonusNumber) {
        WinLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

}
