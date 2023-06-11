package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        Validator.validateSize(numbers);
        Validator.validateDuplicatedNumber(numbers);
    }

    public String getNumString() {
        StringJoiner joiner = new StringJoiner(", ");
        numbers.stream().map(String::valueOf)
                .forEach(joiner::add);
        return String.join("", "[", joiner.toString(), "]");
    }

    public int getNumberByIndex(int index) {
        return numbers.get(index);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

}
