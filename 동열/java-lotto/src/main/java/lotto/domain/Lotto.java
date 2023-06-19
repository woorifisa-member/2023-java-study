package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.validation.Validator;

public class Lotto {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int PRICE = 1_000;
    public static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateLottoNumber(numbers);
        numbers.sort(Integer::compareTo);
        this.numbers = numbers;
    }

    public static Lotto issue() {
        return new Lotto(
            new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                    Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, 6
                )
            )
        );
    }

    public static Lotto issue(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < SIZE; i++) {
            sb.append(numbers.get(i));
            if (i != SIZE - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

}
