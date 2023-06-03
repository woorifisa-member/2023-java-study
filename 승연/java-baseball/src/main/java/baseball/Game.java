package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private final static int MIN_NUM = 1;
    private final static int MAX_NUM = 9;
    private final static int MAX_NUM_SIZE = 3;
    private final static String inputMessage = "숫자를 입력해주세요 : ";
    private ArrayList<Integer> answerNumberList = new ArrayList<Integer>();

    private ArrayList<Integer> getAnswerNumber() {
        while (answerNumberList.size() < MAX_NUM_SIZE) {
            isInAnswerList(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }
        return answerNumberList;
    }

    private void isInAnswerList(int number) {
        if (answerNumberList.contains(number)) {

        } else {
            answerNumberList.add(number);
        }
    }


    private void gameRound(ArrayList<Integer> answerNumberList) {
        ArrayList<Integer> answerNumberList1 = answerNumberList;
        System.out.print(inputMessage);
        String input = Console.readLine();

        // 입력받은 문자열 문자, 숫자 배열로 변환
        String[] inputArray = input.split("");
        Integer[] inputIntArray = Stream.of(inputArray).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        HashSet<String> inputSet = new HashSet<>(Arrays.asList(inputArray));
        // 세자릿수가 아닌 경우 예외처리
        if (inputSet.size() != 3) {
            throw new IllegalArgumentException();
        }

        // 입력값에 따른 strike, ball 카운팅
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answerNumberList1.size(); i++) {
            for (int j = 0; j < inputSet.size(); j++) {
                if ((i == j) && (answerNumberList1.get(i) == inputIntArray[j])) {
                    strike += 1;
                } else if (answerNumberList1.get(i) == inputIntArray[j]) {
                    ball += 1;
                }
            }
        }

        // 입력에 따른 결과 출력
        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            gameRound(answerNumberList1);
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
            gameRound(answerNumberList1);
        } else if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
            gameRound(answerNumberList1);
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            gameRound(answerNumberList1);
        }
    }

    public void gameStart() {
        ArrayList<Integer> answerNumberList = getAnswerNumber();
        // 게임 라운드 시작
        gameRound(answerNumberList);
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String stringIsRestart = Console.readLine();
            int isRestart = Integer.parseInt(stringIsRestart);
            if (isRestart == 1) {
                answerNumberList.clear();
                ArrayList<Integer> newAnswerNumberList = getAnswerNumber();
                gameRound(newAnswerNumberList);
            } else {
                System.out.println("게임 종료");
                return;
            }
        }

    }


}

