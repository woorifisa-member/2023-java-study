package lotto.controller;

import lotto.io.Reader;
import lotto.service.LottoIssueService;
import lotto.service.StatisticsService;

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
    }
}
