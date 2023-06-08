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
        IssuedLotto issuedLotto = issueLotto();

        Writer.println("");

        WinLotto winLotto = issueWinLotto();
        compileStatistics(issuedLotto, winLotto);
    }

    private IssuedLotto issueLotto() {
        Writer.println("구입 금액을 입력해주세요.");
        return lottoIssueService.issueLotto(controller.getPrice());
    }

    private WinLotto issueWinLotto() {
        Writer.println("당첨 번호를 입력해주세요.");
        List<Integer> numbers = controller.getWinNumber();

        Writer.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = controller.getBonusNumber();

        return lottoIssueService.issueWinLotto(numbers, bonusNumber);
    }

    private void compileStatistics(IssuedLotto issuedLotto, WinLotto winLotto) {
        statisticsService.compileStatistics(issuedLotto, winLotto);
    }

}
