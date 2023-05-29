package Compare;
import java.util.Arrays;
public class NumberCompare {
    public static int[] compare(int[] number1, int[] number2) {
        int strike = 0;
        int ball = 0;
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            if (number1[i] == number2[i]) {
                strike++;
            } else if (Arrays.asList(number2).contains(number1[i])) {
                ball++;
            }
        }
        result[0] = strike;
        result[1] = ball;
        return result;

    }
}
