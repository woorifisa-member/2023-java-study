package baseball;

public class Compare {

    public static int compare(int[] user_number, Integer[] computer_number) {
        // TODO Auto-generated method stub

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < user_number.length; i++) {
            for (int j = 0; j < computer_number.length; j++) {
                if (i == j && user_number[i] == computer_number[j]) {
                    strike++;
                } else if (i != j && user_number[i] == computer_number[j]) {
                    ball++;
                }
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
}
