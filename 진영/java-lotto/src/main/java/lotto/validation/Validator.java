package lotto.validation;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validator {

    private Validator() {

    }

    // TODO: 여러 검증 로직을 짜보세요
    public static void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void validate(List<Integer> numList, int number) {
        validateNumberRange(numList);
        validateNumberRange(number);
    }

    public static void validateNumberRange(int num) {
        if (num < Lotto.MIN_LOTTO_NUMBER && Lotto.MAX_LOTTO_NUMBER < num) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateNumberRange(List<Integer> numList) {
        for (Integer num : numList) {
            if (num < Lotto.MIN_LOTTO_NUMBER && Lotto.MAX_LOTTO_NUMBER < num) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : numbers) {
            set.add(i);
        }
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않은 숫자여야 합니다.");
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않은 숫자 6개여야 합니다.");
        }
    }

}
