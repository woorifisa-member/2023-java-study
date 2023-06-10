package lotto.service;

import lotto.domain.*;
import lotto.io.Writer;

public class CheckLottoService {

    public void checkIssuedLotto(IssuedLotto issuedLotto, WinLotto winLotto) {
        for (Lotto lotto : issuedLotto.getLotto()) {
            int matchCount = compareNumbers(lotto, winLotto);
            boolean isBonusNumber = checkBonusNumber(lotto, winLotto.getBonusNumber());
            LottoResult.calculateResult(matchCount, isBonusNumber);
        }
    }

    public void printLottoStatus() {
        for (Rank rank : Rank.values()) {
            int count = rank.getCount();
            int prize = rank.getPrizeMoney();
            Writer.print(LottoResult.formatResult(count, prize, LottoResult.getResult()[rank.ordinal()]));
        }
    }

    private int compareNumbers(Lotto lotto, WinLotto winLotto) {
        int matchCount = 0;
        for (int num : winLotto.getWinLotto()) {
            if (lotto.getNumbers().contains(num)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
