package lotto.console;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinLotto;
import lotto.io.Reader;
import lotto.io.Writer;
import lotto.service.LottoIssueService;
import lotto.service.StatisticsService;
import lotto.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final Reader reader;
    private final Writer writer;
    private final LottoIssueService lottoIssueService;
    private final StatisticsService statisticsService;
    private final Validator validator;

    public Controller(Reader reader, Writer writer, LottoIssueService lottoIssueService,
                      StatisticsService statisticsService, Validator validator) {
        this.reader = reader;
        this.writer = writer;
        this.lottoIssueService = lottoIssueService;
        this.statisticsService = statisticsService;
        this.validator = validator;
    }

    public void run() {
        try {
            int purchaseAmount = getPurchaseAmount();
            int manualTicketCount = getManualTicketCount(purchaseAmount);
            int autoTicketCount = getAutoTicketCount(purchaseAmount, manualTicketCount);
            List<Lotto> lottos = issueLottos(autoTicketCount, manualTicketCount);
            printIssuedLottos(lottos);

            WinLotto winLotto = getWinLotto();
            Rank rank = statisticsService.calculateRank(lottos, winLotto);
            printWinningStatistics(rank, lottos);

        } catch (IllegalArgumentException e) {
            writer.println("[ERROR] " + e.getMessage());
        }
    }

    private int getPurchaseAmount() {
        writer.println("구입금액을 입력해 주세요.");
        String input = reader.readLine();
        return validator.validatePurchaseAmount(input);
    }

    private int getManualTicketCount(int purchaseAmount) {
        writer.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String input = reader.readLine();
        return validator.validateManualTicketCount(input, purchaseAmount);
    }

    private int getAutoTicketCount(int purchaseAmount, int manualTicketCount) {
        return (purchaseAmount / 1000) - manualTicketCount;
    }

    private List<Lotto> issueLottos(int autoTicketCount, int manualTicketCount) {
        List<Lotto> lottos = new ArrayList<>();
        if (manualTicketCount > 0) {
            writer.println("수동으로 구매할 번호를 입력해 주세요.");
            for (int i = 0; i < manualTicketCount; i++) {
                String input = reader.readLine();
                List<Integer> numbers = validator.validateManualTicketNumbers(input);
                lottos.add(new Lotto(numbers));
            }
        }
        for (int i = 0; i < autoTicketCount; i++) {
            lottos.add(lottoIssueService.issueLotto());
        }
        return lottos;
    }

    private void printIssuedLottos(List<Lotto> lottos) {
        writer.println("자동으로 " + (lottos.size() - lottos.size()) + "개, 수동으로 " + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            writer.println(lotto.getNumbers().toString());
        }
    }

    private WinLotto getWinLotto() {
        writer.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = reader.readLine();
        List<Integer> numbers = validator.validateWinningNumbers(input);
        int bonusNumber = validator.validateBonusNumber(input);
        return new WinLotto(numbers, bonusNumber);
    }

    private void printWinningStatistics(Rank rank, List<Lotto> lottos) {
        writer.println("당첨 통계");
        writer.println("---------");
        for (Rank r : Rank.values()) {
            if (r != Rank.MISS) {
                int count = r.getCount(lottos);
                double rate = (double) count / lottos.size() * 100;
                writer.println(r.getCountOfMatch() + "개 일치" + (r == Rank.SECOND ? ", 보너스 볼 일치" : "") +
                        " (" + r.getPrize() + "원) - " + count + "개");
            }
        }
    }
}