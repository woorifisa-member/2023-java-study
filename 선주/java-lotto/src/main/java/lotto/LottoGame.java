package lotto;

import java.util.List;
import lotto.console.Controller;
import lotto.console.HelloControllerImpl;
import lotto.domain.IssuedLotto;
import lotto.domain.WinLotto;
import lotto.io.Writer;
import lotto.service.HelloLottoIssueServiceImpl;
import lotto.service.HelloStatisticsServiceImpl;
import lotto.service.LottoIssueService;
import lotto.service.StatisticsService;
import lotto.validation.Validator;

public class LottoGame {

    private final Controller controller;
    private final LottoIssueService lottoIssueService;
    private final StatisticsService statisticsService;

    private LottoGame() {
        // TODO
        controller = new HelloControllerImpl();
        lottoIssueService = new HelloLottoIssueServiceImpl();
        statisticsService = new HelloStatisticsServiceImpl();
    }

    public static void run() {
        LottoGame lottoGame = new LottoGame();

        try {
            lottoGame.start();
        } catch (IllegalArgumentException e) {
            Writer.print(e.getMessage());
        }
    }

    private void start() {
        IssuedLotto issuedLotto = issueLotto();
        WinLotto winLotto =
                issueWinLotto();
        compileStatistics(issuedLotto, winLotto);
    }

    private IssuedLotto issueLotto() {
        long price = controller.getPrice();

        IssuedLotto issuedLotto = lottoIssueService.issueLotto(price);

        return issuedLotto;
    }

    private WinLotto issueWinLotto() {
        List<Integer> numbers = controller.getWinNumber();

        int bonusNumber = controller.getBonusNumber();

        return lottoIssueService.issueWinLotto(numbers, bonusNumber);
    }

    private void compileStatistics(IssuedLotto issuedLotto, WinLotto winLotto) {
        statisticsService.compileStatistics(issuedLotto, winLotto);
    }

}
