package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;

import java.util.*;

public class LottoIssueService {
    public IssuedLotto issueLotto(long price){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < price ; i+=Lotto.PRICE){
            Lotto lotto = new Lotto(generateNumber());
            lottos.add(lotto);
        }
        return new IssuedLotto(lottos);
    }

    public WinLotto issueWinLotto(List<Integer> numbers, int bonusNumber){
        return null;
    }

    public List<Integer> generateNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
}
