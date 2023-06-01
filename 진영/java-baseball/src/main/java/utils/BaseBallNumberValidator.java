package utils;

import java.util.List;

public class BaseBallNumberValidator {
    public int ball;
    public int strike;
    public StringBuilder stringBuilder = new StringBuilder();

    public boolean checkInningResult(List<Integer> aiNumberList, List<Integer> personNumberList) {

        for (int i = 0; i < aiNumberList.size(); i++) {
            if (aiNumberList.get(i) == personNumberList.get(i)) {
                strike++;
            } else if (personNumberList.contains(aiNumberList.get(i))) {
                ball++;
            }
        }

        boolean isStrike = true;
        if (strike != 3) {
            if (ball > 0) {
                stringBuilder.append(ball + "볼 ");
            }
            if (strike > 0) {
                stringBuilder.append(strike + "스트라이크");
            }
            if (ball > 0 || strike > 0) {
                stringBuilder.append("\n");
            }
            if (ball == 0 && strike == 0) {
                stringBuilder.append("낫싱");
            }
            System.out.println(stringBuilder.toString());
            isStrike = false;
        }

        initInningCount();
        return isStrike;
    }

    public void initInningCount() {
        ball = 0;
        strike = 0;
    }
}
