package lotto;

import java.util.List;
import lotto.console.Controller;
import lotto.console.ControllerImpl;
import lotto.domain.IssuedLotto;
import lotto.domain.WinLotto;
import lotto.domain.WinResult;
import lotto.io.Writer;
import lotto.service.LottoIssueService;
import lotto.service.LottoIssueServiceImpl;
import lotto.service.StatisticsService;
import lotto.service.StatisticsServiceImpl;
import lotto.validation.Validator;

public class LottoGame {

    private final Controller controller;
    private final LottoIssueService lottoIssueService;
    private final StatisticsService statisticsService;

    private LottoGame() {
        controller = new ControllerImpl();
        lottoIssueService = new LottoIssueServiceImpl();
        statisticsService = new StatisticsServiceImpl();
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
        WinResult winResult = compileStatistics(issuedLotto, winLotto);

        Writer.println(winResult);
    }

    private IssuedLotto issueLotto() {
        Writer.println("구입 금액을 입력해주세요.");
        IssuedLotto issuedLotto = lottoIssueService.issueLotto(controller.getPrice());

        Writer.println(String.format("%d개를 구매했습니다.", issuedLotto.getLotto().size()));
        issuedLotto.getLotto()
                   .forEach(Writer::println);

        return issuedLotto;
    }

    private WinLotto issueWinLotto() {
        Writer.println("당첨 번호를 입력해주세요.");
        List<Integer> numbers = controller.getWinNumber();

        Writer.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = controller.getBonusNumber();

        Validator.validateDuplicate(numbers, bonusNumber);

        return lottoIssueService.issueWinLotto(numbers, bonusNumber);
    }

    private WinResult compileStatistics(IssuedLotto issuedLotto, WinLotto winLotto) {
        return statisticsService.compileStatistics(issuedLotto, winLotto);
    }

}
