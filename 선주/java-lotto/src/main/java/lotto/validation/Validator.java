package lotto.validation;

import lotto.domain.Lotto;

import java.util.List;

public final class Validator {

    private Validator() {

    }

    // TODO: 여러 검증 로직을 짜보세요
    public static List<Integer> validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    public static void validateBonusLottoLength(List<Integer> numbers) {
        if (numbers.size() != 1) {
            throw new IllegalArgumentException();
        }
    }


    public static long validatePrice(String price){
        try{
            long validprice = Long.parseLong(price);
            if (validprice % Lotto.PRICE != 0 ){
                throw new IllegalArgumentException("[ERROR] 1000단위로 입력해주세요.");
            }
            return validprice;
        }catch ( NumberFormatException e ){
            throw new IllegalArgumentException("[ERROR] 순수 숫자만 입력해주세요.");
        }
    }

    public static int validateNumber(String number){
        try {
            int num = Integer.parseInt(number);
            if (num < Lotto.MIN_LOTTO_NUMBER || num > Lotto.MAX_LOTTO_NUMBER){
                throw new IllegalArgumentException("[ERROR] 번호는 1 ~ 45 중에 입력할 수 있습니다.");
            }

            return num;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 순수 숫자만 입력해주세요.");
        }

    }

    public static List<Integer> validateDuplication(List<Integer> numbers){
        boolean[] validNumber = new boolean[46];

        for(int n : numbers){
            if (validNumber[n]) {
                throw new IllegalArgumentException("[ERROR] 중복된 값은 입력 불가합니다.");
            }
            validNumber[n] = true;

        }

        return numbers;
    }

}
