package lotto.controller;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.io.Reader;
import lotto.io.Writer;
import lotto.service.LottoIssueService;
import lotto.service.StatisticsService;

import java.util.List;
import java.util.function.Supplier;

public class LottoController {
    private final LottoIssueService lottoIssueService;
    private final StatisticsService statisticsService;
    private final Reader reader;

    public LottoController(){
        lottoIssueService = new LottoIssueService();
        statisticsService = new StatisticsService();
        reader = new Reader();
    }

    public void startGame(){
        Integer purchaseAmount = reader.inputPurchaseAmount();
        IssuedLotto issuedLotto = lottoIssueService.issueLotto(purchaseAmount);
        Writer.printMyLottoList(issuedLotto);
    }



}
