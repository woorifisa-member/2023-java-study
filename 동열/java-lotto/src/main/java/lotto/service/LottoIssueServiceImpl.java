package lotto.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;

public class LottoIssueServiceImpl implements LottoIssueService {

    @Override
    public IssuedLotto issueLotto(long price) {
        int count = (int) (price / Lotto.PRICE);

        List<Lotto> lottoList = IntStream.range(0, count)
                                         .mapToObj(i -> Lotto.issue())
                                         .collect(toList());

        return new IssuedLotto(lottoList);
    }

    @Override
    public WinLotto issueWinLotto(List<Integer> numbers, int bonusNumber) {
        return null;
    }
}
