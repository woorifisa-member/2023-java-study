package baseball;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class Game {

    public static void play(){
        Integer[] arr = randomNumber();
        System.out.print("숫자를 입력해주세요:");
        String text = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println(arr);
    }
    public static Integer[] randomNumber(){
        int firstNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9);
        int secondNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9);
        int thirdNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9);

        Integer[] arr = new Integer[3];
        arr[0] = firstNumber;
        arr[1] = secondNumber;
        arr[2] = thirdNumber;

        return arr;
    }
}
