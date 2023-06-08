package lotto.validation;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public final class Validator {

    public static final String ERROR = "[ERROR] ";

    private Validator() {

    }

    // TODO: 여러 검증 로직을 짜보세요
    public static void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static long validPriceInput(String price) {
        try {
            return Long.parseLong(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + "잘못된 가격을 입력했습니다.");
        }
    }

    public static List<Integer> validWinNumberInput(String numbers) {
        String[] nums = numbers.split(",");

        try {

            return Arrays.stream(nums)
                         .map(n -> Integer.parseInt(n.trim()))
                         .collect(toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + "잘못된 당첨번호를 입력했습니다.");
        }
    }

}
