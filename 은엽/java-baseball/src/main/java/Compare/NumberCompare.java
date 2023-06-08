package Compare;

import java.util.Arrays;

public class NumberCompare {
    public static int[] compare(int[] number1, String[] number2) {
//        CheckBall cb = new CheckBall();
        int strike = 0;
        int ball = 0;
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            strike += CheckBall.checkStrike(number1[i], number2[i]);
            ball += CheckBall.checkBall(number1[i], number2, i);
        }
        result[0] = strike;
        result[1] = ball;
        return result;
    }
}