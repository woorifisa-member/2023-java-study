package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.lang.IllegalArgumentException;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private final static int MIN_NUM = 1;
    private final static int MAX_NUM = 9;
    private final static int MAX_NUM_SIZE = 3;
    private final static String inputMessage = "숫자를 입력해주세요 : ";
    ArrayList<Integer> answerNumberList = new ArrayList<Integer>();

    public ArrayList<Integer> GetAnswerNumber() {
        while (answerNumberList.size() < MAX_NUM_SIZE) {
            isInAnswerList(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }
        return answerNumberList;
    }

    public void isInAnswerList(int number) {
        if (answerNumberList.contains(number)) {

        } else {
            answerNumberList.add(number);
        }
    }
    Boolean flag = false;
    public void gameRound(ArrayList<Integer> answerNumberList) {
        ArrayList<Integer> answerNumberList1 = answerNumberList;
        System.out.print(inputMessage);
        String tmp = Console.readLine();
        int input = Integer.parseInt(tmp);
        if ((int) (Math.log10(input) + 1) != 3) {
            throw new IllegalArgumentException();
        }
        int[] inputIntArray = Stream.of(String.valueOf(input).split("")).mapToInt(Integer::parseInt).toArray();
        Integer[] inputIntegerArray = Arrays.stream(inputIntArray).boxed().toArray(Integer[]::new);
        Set<Integer> inputSet = new HashSet<Integer>(Arrays.asList(inputIntegerArray));

        // 세자릿수가 아닌 경우 예외처리
        if ((int) (Math.log10(input) + 1) != 3) {
            throw new IllegalArgumentException();
        }

        // 입력값에 따른 strike, ball 카운팅
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answerNumberList1.size(); i++) {
            for (int j = 0; j < inputIntArray.length; j++) {
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
            return;
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
        ArrayList<Integer> answerNumberList = GetAnswerNumber();
        // 게임 라운드 시작
        Boolean flag = false;
        gameRound(answerNumberList);
        while(true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String stringIsRestart = Console.readLine();
            int isRestart = Integer.parseInt(stringIsRestart);
            if (isRestart == 1) {
                answerNumberList.clear();
                ArrayList<Integer> newAnswerNumberList = GetAnswerNumber();
                gameRound(newAnswerNumberList);
            } else {
                System.out.println("게임 종료");
                return;
            }
        }

    }


}

