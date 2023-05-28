package utils;

import java.util.List;

public class BaseBallNumberValidator {
    public int ball;
    public int strike;

    public boolean checkInningResult(List<Integer> aiNumberList, List<Integer> personNumberList) {

        for (int i = 0; i < aiNumberList.size(); i++) {
            if (aiNumberList.get(i) == personNumberList.get(i)) {
                strike++;
            } else if (personNumberList.contains(aiNumberList.get(i))) {
                ball++;
            }
        }

        if (strike != 3) {
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            if (ball > 0 || strike > 0) {
                System.out.println();
            }
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            }
            initInningCount();
            return false;
        }
        initInningCount();
        return true;
    }

    public void initInningCount() {
        ball = 0;
        strike = 0;
    }
}
