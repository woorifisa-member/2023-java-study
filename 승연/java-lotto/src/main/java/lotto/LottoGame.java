package lotto;

import java.util.List;

import lotto.console.Controller;
import lotto.console.UserInput;
import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.io.Writer;
import lotto.service.CompareLotto;
import lotto.service.IssueLotto;
import lotto.service.LottoIssueService;
import lotto.service.StatisticsService;
import lotto.io.Writer;

public class LottoGame {

    private final Controller controller;
    private final LottoIssueService lottoIssueService;
    private final StatisticsService statisticsService;

    public LottoGame() {
        // TODO
        controller = new UserInput();
        lottoIssueService = new IssueLotto();
        statisticsService = new CompareLotto();
    }

    public static void run() {
        LottoGame lottoGame = new LottoGame();

        try {
            lottoGame.start();
        } catch (IllegalArgumentException e) {

        }
    }

    private void start() {
        IssuedLotto issuedLotto = issueLotto();
        WinLotto winLotto = issueWinLotto();
        compileStatistics(issuedLotto, winLotto);
    }

    private IssuedLotto issueLotto() {
        Writer.println("구매금액을 입력해 주세요.");
        long price = controller.getPrice();
        int numLotto = (int) price / 1000;
        Writer.println(" ");
        Writer.print(numLotto);
        Writer.println("개를 구매했습니다.");

        IssuedLotto issuedLotto = lottoIssueService.issueLotto(price);
        for (Lotto oneLotto : issuedLotto.lotto) {
            Writer.println(oneLotto.numbers);
        }
        return issuedLotto;
    }

    private WinLotto issueWinLotto() {
        Writer.println(" ");
        Writer.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = controller.getWinNumber();
        Writer.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = controller.getBonusNumber();

        WinLotto winLotto = lottoIssueService.issueWinLotto(numbers, bonusNumber);

        return null;
    }

    private void compileStatistics(IssuedLotto issuedLotto, WinLotto winLotto) {
        Writer.println("당첨 통계");
        Writer.println("---");
        statisticsService.compileStatistics(issuedLotto, winLotto);
    }


}
