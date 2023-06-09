package lotto.validation;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.domain.Lotto;

public final class Validator {

    public static final String ERROR = "[ERROR] ";
    public static final String ERROR_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private Validator() {

    }

    // TODO: 여러 검증 로직을 짜보세요
    public static void validateLottoNumber(List<Integer> numbers) {
        HashSet<Integer> nums = new HashSet<>(numbers);
        if (nums.size() != Lotto.SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static long validatePriceInput(String price) {
        try {
            long result =  Long.parseLong(price);

            if (result < Lotto.PRICE || result % Lotto.PRICE != 0) {
                throw new NumberFormatException();
            }
            
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + "잘못된 가격을 입력했습니다.");
        }
    }

    public static List<Integer> validateWinNumberInput(String numbers) {
        String[] nums = numbers.split(",");

        try {

            return Arrays.stream(nums)
                         .map(n -> checkNumber(Integer.parseInt(n.trim())))
                         .collect(toList());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + ERROR_MESSAGE);
        }
    }

    public static int validateBonusNumberInput(String number) {
        try {

            int bonusNumber = Integer.parseInt(number);

            return checkNumber(bonusNumber);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + ERROR_MESSAGE);
        }
    }

    private static int checkNumber(int number) {
        if (number < Lotto.MIN_LOTTO_NUMBER || Lotto.MAX_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException(ERROR + ERROR_MESSAGE);
        }
        return number;
    }

    public static void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR + "중복된 번호를 입력했습니다.");
        }
    }
}
