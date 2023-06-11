package lotto.service;

import lotto.domain.IssuedLotto;
import lotto.domain.WinLotto;
import lotto.domain.WinResult;

public interface StatisticsService {

    // TODO: return 타입은 자유롭게 바꿔보세요.
    WinResult compileStatistics(IssuedLotto issuedLotto, WinLotto winLotto);

}
