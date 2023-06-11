package lotto.controller;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinLotto;
import lotto.io.Reader;
import lotto.io.Writer;
import lotto.service.LottoIssueService;
import lotto.service.StatisticsService;
import lotto.validation.Validator;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoIssueService lottoIssueService;
    private final StatisticsService statisticsService;
    private final Reader reader;
    private Integer purchaseAmount;

    public LottoController() {
        lottoIssueService = new LottoIssueService();
        statisticsService = new StatisticsService();
        reader = new Reader();
    }

    public IssuedLotto purchaseLotto() {
        purchaseAmount = reader.inputPurchaseAmount();
        IssuedLotto issuedLotto = lottoIssueService.issueLotto(purchaseAmount);
        Writer.printMyLottoList(issuedLotto);
        return issuedLotto;
    }

    public WinLotto setWinLotto() {
        List<Integer> winNumberList = reader.inputWinNumberList();
        int bonusNumber = reader.inputBonusNumber();
        Validator.validate(winNumberList, bonusNumber);

        WinLotto winLotto = new WinLotto(new Lotto(winNumberList), bonusNumber);
        return winLotto;
    }

    public void endGame(IssuedLotto issuedLotto, WinLotto winLotto) {
        Map<Rank, Integer> map = statisticsService.compileStatistics(issuedLotto, winLotto);
        Writer.printLottoResult(purchaseAmount, map);
    }

}
