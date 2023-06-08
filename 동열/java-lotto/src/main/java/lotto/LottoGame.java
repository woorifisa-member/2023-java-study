package lotto;

import java.util.List;
import lotto.console.Controller;
import lotto.console.ControllerImpl;
import lotto.domain.IssuedLotto;
import lotto.domain.WinLotto;
import lotto.io.Writer;
import lotto.service.LottoIssueService;
import lotto.service.LottoIssueServiceImpl;
import lotto.service.StatisticsService;

public class LottoGame {

    private final Controller controller;
    private final LottoIssueService lottoIssueService;
    private final StatisticsService statisticsService;

    private LottoGame() {
        // TODO
        controller = new ControllerImpl();
        lottoIssueService = new LottoIssueServiceImpl();
        statisticsService = null;
    }

    public static void run() {
        LottoGame lottoGame = new LottoGame();

        try {
            lottoGame.start();
        } catch (IllegalArgumentException e) {
            Writer.println(e.getMessage());
        }
    }

    private void start() {
        Writer.println("구입 금액을 입력해주세요.");
        IssuedLotto issuedLotto = issueLotto();

        Writer.println("");

        Writer.println("당첨 번호를 입력해주세요.");
        WinLotto winLotto = issueWinLotto();
        compileStatistics(issuedLotto, winLotto);
    }

    private IssuedLotto issueLotto() {
        return lottoIssueService.issueLotto(controller.getPrice());
    }

    private WinLotto issueWinLotto() {
        List<Integer> numbers = controller.getWinNumber();
        int bonusNumber = controller.getBonusNumber();

        WinLotto winLotto = lottoIssueService.issueWinLotto(numbers, bonusNumber);

        return null;
    }

    private void compileStatistics(IssuedLotto issuedLotto, WinLotto winLotto) {
        statisticsService.compileStatistics(null, null);
    }

}
