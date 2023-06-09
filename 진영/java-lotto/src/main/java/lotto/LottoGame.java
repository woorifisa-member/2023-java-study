package lotto;

import lotto.controller.LottoController;
import lotto.domain.IssuedLotto;
import lotto.domain.WinLotto;

public class LottoGame {

    private final LottoController lottoController;

    private LottoGame() {
        // TODO
        lottoController = new LottoController();
    }

    public static void run() {
        try {
            LottoGame lottoGame = new LottoGame();
            IssuedLotto issuedLotto = lottoGame.lottoController.purchaseLotto();
            WinLotto winLotto = lottoGame.lottoController.setWinLotto();
            lottoGame.lottoController.endGame(issuedLotto, winLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }

}
