package baseball;

public class Compare {

    public static int compare(int[] user_number, Integer[] computer_number) {
        // TODO Auto-generated method stub

        int strike = 0;
        int ball = 0;
        int[] res = new int[2];

        for (int i = 0; i < user_number.length; i++) {
            for (int j = 0; j < computer_number.length; j++) {
                res = strikeOrBall(i, j, user_number, computer_number, strike, ball);
                strike = res[0];
                ball = res[1];
            }

        }


        if (strike == 0 && ball == 0) {
            System.out.printf("낫싱");
        } else if (strike != 0 && ball == 0) {
            System.out.printf("%d스트라이크", strike);
        } else if (strike == 0 && ball != 0) {
            System.out.printf("%d볼", ball);
        } else {
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }
        System.out.println();

        return strike;

    }

    public static int[] strikeOrBall(int i, int j, int[] user_number, Integer[] computer_number, int strike, int ball) {
        if (i == j && user_number[i] == computer_number[j]) {
            strike++;
        } else if (i != j && user_number[i] == computer_number[j]) {
            ball++;
        }

        int[] res = new int[2];
        res[0] = strike;
        res[1] = ball;

        return res;
    }
}
