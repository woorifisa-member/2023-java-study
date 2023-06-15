package lotto.domain;

import java.util.List;

public class WinLotto {

    private final Lotto winLotto;
    private final int bonusNumber;

    public WinLotto(Lotto winLotto, int bonusNumber) {
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinLotto() {
        return winLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
