package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validator {

    private Validator() {

    }

    // TODO: 여러 검증 로직을 짜보세요
    public static void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static void validate(List<Integer> numList, int number){
        validateNumberRange(numList);
        validateNumberRange(number);
        validateDuplicatedNumber(numList,number);
    }
    public static void validateNumberRange(int num){
            if( num < 1 && 45 < num){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
    }

    public static void validateNumberRange(List<Integer> numList){
        for(Integer num : numList){
            if( num < 1 && 45 < num){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numList, int number){
        Set<Integer> set = new HashSet<>();
        for(Integer num : numList){
            set.add(num);
        }
        set.add(number);
        if(set.size() != 7){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 중복이 없는 숫자여야 합니다.");
        }
    }
}
