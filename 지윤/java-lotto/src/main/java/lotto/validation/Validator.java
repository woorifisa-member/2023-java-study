package lotto.validation;

import lotto.domain.Lotto;

import java.util.List;

public final class Validator {

    private Validator() {

    }

    // TODO: 여러 검증 로직을 짜보세요
    public static void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputPrice(long price) {
        if (price % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("금액은 천원단위로 입력해주세요.");
        }
    }

    public static void validateInputWinNumber(String inputNumbers) {
        String[] inputArr = inputNumbers.split(",");
        if (inputArr.length != 6) {
            throw new IllegalArgumentException("숫자 6개를 쉽표로 구분지어 입력해주세요.");
        }
        for (String input : inputArr) {
            int parsedIntInput = Integer.parseInt(input);
            validateRangeOfNumbers(parsedIntInput);
        }
    }

    public static void validateRangeOfNumbers(int number) {
        if (!(number >= Lotto.MIN_LOTTO_NUMBER && number <= Lotto.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("1 ~ 45사이의 숫자만 입력해주세요.");
        }
    }

}
