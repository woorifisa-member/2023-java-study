package lotto.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public int validatePurchaseAmount(String input) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자로 입력해야 합니다.");
        }

        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("구입금액은 0보다 큰 값을 입력해야 합니다.");
        }

        return purchaseAmount;
    }

    public int validateManualTicketCount(String input, int purchaseAmount) {
        int manualTicketCount;
        try {
            manualTicketCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 숫자로 입력해야 합니다.");
        }

        if (manualTicketCount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 0보다 크거나 같은 값을 입력해야 합니다.");
        }

        int totalTicketCount = purchaseAmount / 1000;
        if (manualTicketCount > totalTicketCount) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 총 구매 가능한 로또 수를 초과할 수 없습니다.");
        }

        return manualTicketCount;
    }

    public List<Integer> validateManualTicketNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString.trim());
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 값을 가져야 합니다.");
                }
                if (numbers.contains(number)) {
                    throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("로또 번호는 숫자로 입력해야 합니다.");
            }
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 총 6개를 입력해야 합니다.");
        }

        return numbers;
    }

    public List<Integer> validateWinningNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            try {
                int number = Integer.parseInt(numberString.trim());
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 값을 가져야 합니다.");
                }
                if (numbers.contains(number)) {
                    throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("로또 번호는 숫자로 입력해야 합니다.");
            }
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 총 6개를 입력해야 합니다.");
        }

        return numbers;
    }

    public int validateBonusNumber(String input) {
        String[] numberStrings = input.split(",");
        if (numberStrings.length != 7) {
            throw new IllegalArgumentException("당첨 번호와 보너스 볼을 모두 입력해야 합니다.");
        }

        try {
            return Integer.parseInt(numberStrings[6].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 볼은 숫자로 입력해야 합니다.");
        }
    }
}