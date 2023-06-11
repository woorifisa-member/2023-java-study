package lotto;

import lotto.console.Controller;
import lotto.io.Reader;
import lotto.io.Writer;
import lotto.service.LottoIssueService;
import lotto.service.StatisticsService;
import lotto.validation.Validator;

public class Application {
    public static void main(String[] args) {
        Reader reader = new Reader();
        Writer writer = new Writer();
        LottoIssueService lottoIssueService = new LottoIssueService();
        StatisticsService statisticsService = new StatisticsService();
        Validator validator = new Validator();
        Controller controller = new Controller(reader, writer, lottoIssueService, statisticsService, validator);
        controller.run();
    }
}