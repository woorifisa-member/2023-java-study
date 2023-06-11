package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;

import java.util.ArrayList;
import java.util.List;

public class IssueLotto implements LottoIssueService{

    // 로또 랜덤 숫자 생성
    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < Lotto.SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    // 구매한 가격만큼 로또 발행
    public IssuedLotto issueLotto(long price){
        List<Lotto> lottoList = new ArrayList<>();
        for (int i=0; i<price/1_000; i++){
            Lotto lotto = new Lotto(generateRandomNumbers());
            lottoList.add(lotto);
        }
        return new IssuedLotto(lottoList);
    }


    public WinLotto issueWinLotto(List<Integer> numbers, int bonusNumber){
        // (Lotto) 적용 원리 확인
        WinLotto winLotto = new WinLotto((Lotto)numbers, bonusNumber);
        return winLotto;
    }


}
