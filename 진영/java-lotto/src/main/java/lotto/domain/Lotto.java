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
        validateSize(numbers);
        validateDuplicatedNumber(numbers);
    }
    public String getNumString(){
        StringJoiner joiner = new StringJoiner(", ");
        numbers.stream().map(String::valueOf)
                .forEach(joiner::add);
        return String.join("","[",joiner.toString(),"]");
    }

    public int getNumberByIndex(int index){
        return numbers.get(index);
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    private void validateDuplicatedNumber(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();
        for (Integer i : numbers){
            set.add(i);
        }
        if(set.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않은 숫자여야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않은 숫자 6개여야 합니다.");
        }
    }
}
