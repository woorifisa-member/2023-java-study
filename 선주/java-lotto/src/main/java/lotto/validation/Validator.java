package lotto.validation;

import lotto.domain.Lotto;

import java.util.List;

public final class Validator {

    private Validator() {

    }

    // TODO: 여러 검증 로직을 짜보세요
    public static void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void validatePrice(long price){
        if (price % Lotto.PRICE != 0 ){
            throw new IllegalArgumentException("[ERROR] 1000단위로 입력해주세요.");
        }
    }

    public static void validateNumber(int number){
        if (number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException("[ERROR] 번호는 1 ~ 45 중에 입력할 수 있습니다.");
        }
    }

}
