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
        Set<Integer> checkSet = new HashSet<>(numbers);
        if (checkSet.size() != 6) {
            throw new IllegalArgumentException("중복되지 않은 숫자 6개를 입력해주세요");
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputPrice(String price) {
        boolean isNumeric = price.matches("^[0-9]*?");
        if (Long.parseLong(price) % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("금액은 천원단위로 입력해주세요.");
        }
        if(!isNumeric) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }

    }

    public static void validateInputWinNumber(String inputNumbers) {
        String[] inputArr = inputNumbers.split(",");
        Set<Integer> checkSet = new HashSet<>();
        if (inputArr.length != 6) {
            throw new IllegalArgumentException("숫자 6개를 쉼표로 구분지어 입력해주세요.");
        }
        for (String input : inputArr) {
            int parsedIntInput = Integer.parseInt(input);
            checkSet.add(parsedIntInput);
            validateRangeOfNumbers(parsedIntInput);

        }
        if (checkSet.size() != 6) {
            throw new IllegalArgumentException("중복되지 않은 숫자 6개를 입력해주세요");
        }

    }

    public static void validateInputBonusNumber(int bonusNumber, List<Integer> winLotto) {
        validateRangeOfNumbers(bonusNumber);
        for (int winNum : winLotto) {
            if (winNum == bonusNumber) {
                throw new IllegalArgumentException("해당 숫자는 이미 당첨번호에 있습니다. 당첨번호에 없는 번호를 넣어주세요.");
            }
        }
    }


    public static void validateRangeOfNumbers(int number) {
        if (number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }


}
