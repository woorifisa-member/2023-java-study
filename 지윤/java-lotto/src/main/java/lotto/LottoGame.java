package lotto;

import java.util.List;

import lotto.console.Controller;
import lotto.console.ControllerImpl;
import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.io.Writer;
import lotto.service.*;

public class LottoGame {
    private final Controller controller;
    private final LottoIssueService lottoIssueService;
    private final StatisticsService statisticsService;
    private final CheckLottoService checkLottoService;

    private long userPrice;

    private LottoGame() {
        // TODO
        controller = new ControllerImpl();
        lottoIssueService = new LottoIssueServiceImpl();
        checkLottoService = new CheckLottoService();
        statisticsService = new StatisticsServiceImpl();
        userPrice = controller.getPrice();
    }

    public static void run() {
        LottoGame lottoGame = new LottoGame();
        try {
            lottoGame.start();
        } catch (IllegalArgumentException e) {
            Writer.println("[ERROR] " + e.getMessage());
        }
    }

    private void start() {
        IssuedLotto issuedLotto = issueLotto();
        WinLotto winLotto = issueWinLotto();
        checkLottoResult(issuedLotto,winLotto);
        compileStatistics();
    }

    private IssuedLotto issueLotto() {
        return  lottoIssueService.issueLotto(userPrice / Lotto.PRICE);
    }

    private WinLotto issueWinLotto() {
        List<Integer> numbers = controller.getWinNumber();
        int bonusNumber = controller.getBonusNumber(numbers);
        return lottoIssueService.issueWinLotto(numbers, bonusNumber);
    }

    public void checkLottoResult(IssuedLotto issuedLotto, WinLotto winLotto) {
        checkLottoService.checkIssuedLotto(issuedLotto, winLotto);
        checkLottoService.printLottoStatus();
    }

    private void compileStatistics() {
        statisticsService.compileStatistics(userPrice);
        Writer.print(statisticsService.toString());
    }

}
