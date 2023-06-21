package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.validation.Validator;

public class Lotto {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int PRICE = 1_000;
    public static final int SIZE = 6;

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        Validator.validateLottoLength(numbers);
        Validator.validateDuplication(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < this.numbers.size(); i++){
            stringBuilder.append(this.numbers.get(i));
            if (i < this.numbers.size() - 1){
                stringBuilder.append(", ");
            }

        }
        return String.valueOf(stringBuilder.append("]"));
    }


}
