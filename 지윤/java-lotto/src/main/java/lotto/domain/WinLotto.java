package lotto.domain;

import java.util.List;

public class WinLotto {

    private final Lotto WINLOTTO;
    private final int bonusNumber;

    public WinLotto(Lotto winLotto, int bonusNumber) {
        WINLOTTO = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinLotto() {
        return WINLOTTO.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
