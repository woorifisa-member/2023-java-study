package lotto.domain;

import java.util.List;
import lotto.validation.Validator;

public class Lotto {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int PRICE = 1_000;
    public static final int SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateLottoLength(numbers);
        this.numbers = numbers;
    }

    // Done: 기능 추가 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

}
