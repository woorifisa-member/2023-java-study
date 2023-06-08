package Compare;

public class CheckBall {
    public static int checkStrike(int num1, String num2) {
        if (num1 == Integer.parseInt(num2)) {
            return 1;
        }
        return 0;
    }
    public static int checkBall(int num1, String[] num2, int excludeIndex) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (i != excludeIndex && num1 == Integer.parseInt(num2[i])) {
                ball++;
                break;
            }
        }
        return ball;
    }
}
