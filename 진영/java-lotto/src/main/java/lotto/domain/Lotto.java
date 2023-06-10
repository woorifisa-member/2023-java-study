package lotto.domain;

import java.util.List;
import java.util.StringJoiner;

import lotto.validation.Validator;

public class Lotto {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int PRICE = 1_000;
    public static final int SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public String getNumString(){
        StringJoiner joiner = new StringJoiner(", ");
        numbers.stream().map(String::valueOf)
                .forEach(joiner::add);
        return String.join("","[",joiner.toString(),"]");
    }
}
