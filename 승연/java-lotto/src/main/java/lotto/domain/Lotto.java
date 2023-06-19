package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lotto.validation.Validator;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int PRICE = 1_000;
    public static final int SIZE = 6;

    // LottoGame 파일에서 출력시 사용하려고 public으로 변경
    public final List<Integer> numbers;


    // 생성자
    public Lotto(List<Integer> numbers) {
        Validator.validateLottoLength(numbers);
        this.numbers = numbers;
    }


    // TODO: 추가 기능 구현
    // 어떤 기능 구현..??

}
