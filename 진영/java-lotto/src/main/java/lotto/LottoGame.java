package lotto;

import lotto.controller.LottoController;

public class LottoGame {

    private final LottoController lottoController;

    private LottoGame() {
        // TODO
        lottoController = new LottoController();
    }

    public static void run() {
        LottoGame lottoGame = new LottoGame();
        lottoGame.lottoController.startGame();
    }

}
