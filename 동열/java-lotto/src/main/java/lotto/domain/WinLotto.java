package lotto.domain;

import java.util.List;

public class WinLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
