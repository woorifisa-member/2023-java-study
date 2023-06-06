package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.io.Writer;

import java.util.ArrayList;
import java.util.List;

public class LottoIssueServiceImpl implements LottoIssueService {

    // 로또를 생성해주는 메서드
    private Lotto createLotto() {
        List<Integer> randomLottoNum = Randoms.pickUniqueNumbersInRange(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.SIZE);
        return new Lotto(randomLottoNum);
    }

    @Override
    public IssuedLotto issueLotto(long price) {
        List<Lotto> listOfLotto = new ArrayList<>();
        // 입력받은 금액에 따라서 로또를 발행 해준다.
        for (int i = 0; i < price; i++) {
            Lotto lotto = createLotto();
            listOfLotto.add(lotto);
        }
        // 로또를 출력해준다.
        Writer.println(price + "개를 구매했습니다.");
        for (Lotto lotto : listOfLotto) {
            Writer.println(lotto.getNumbers());
        }
        // 발행한 로또 리스트는 IssuedLotto 객체를 생성해서 넣어준다.
        return new IssuedLotto(listOfLotto);
    }

    @Override
    public WinLotto issueWinLotto(List<Integer> numbers, int bonusNumber) {
        return null;
    }
}
