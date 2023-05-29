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
        while (answerNumberList.size() < MAX_NUM_SIZE){
            isInAnswerList(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
        }
        return answerNumberList;
    }
    public void isInAnswerList(int number){
        if (answerNumberList.contains(number)) {

        }else{
            answerNumberList.add(number);
        }
    }

    public void gameRound(ArrayList<Integer> answerNumberList){
//        final ArrayList<Integer> answerNumberList = answerNumberList;
        System.out.print(inputMessage);
        String tmp = Console.readLine();
        // 문자 입력 예외처리
        try{
            int input = Integer.parseInt(tmp);
        }catch(IllegalArgumentException e){
            System.out.println("에러 메시지 : 문자는 입력할 수 없습니다.");
            System.exit(0);
        }

        try{
            int input = Integer.parseInt(tmp);
            // 세자릿수가 아닌 경우 예외처리
            if ((int)(Math.log10(input)+1) != 3){
                throw new IllegalArgumentException("세자릿수만 입력 가능합니다.");
            }
            // 중복된 숫자가 있는 경우 예외처리
            int[] inputIntArray = Stream.of(String.valueOf(input).split("")).mapToInt(Integer::parseInt).toArray();
            Integer[] inputIntegerArray = Arrays.stream(inputIntArray).boxed().toArray(Integer[]::new);
            Set<Integer> inputSet = new HashSet<Integer>(Arrays.asList(inputIntegerArray));
            if (inputSet.size() < 3){
                throw new IllegalArgumentException("중복된 값을 입력할 수 없습니다.");
            }
        }catch(IllegalArgumentException e){
            System.out.println("에러 메세지 : " + e.getMessage());
            System.exit(0);
        }
        int input = Integer.parseInt(tmp);
        int[] inputIntArray = Stream.of(String.valueOf(input).split("")).mapToInt(Integer::parseInt).toArray();
        int strike = 0;
        int ball = 0;
        for (int i=0; i<answerNumberList.size(); i++){
            for (int j=0; j<inputIntArray.length; j++){
                if ((i == j) && (answerNumberList.get(i) == inputIntArray[j])) {
                    strike += 1;
                }else if (answerNumberList.get(i) == inputIntArray[j]){
                    ball += 1;
                }
            }
        }

        if (strike == 3){
            System.out.println(strike+"스트라이크");
            System.exit(0);
        }else if (strike == 0 && ball == 0){
            System.out.println("낫싱");
            gameRound(answerNumberList);
        }else if (strike == 0 && ball != 0){
            System.out.println(ball+"볼");
            gameRound(answerNumberList);
        }else if (ball == 0 && strike != 0){
            System.out.println(strike+"스트라이크");
            gameRound(answerNumberList);
        }else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
            gameRound(answerNumberList);
        }
    }

    public void gameStart(){
        final ArrayList<Integer> answerNumberList = GetAnswerNumber();
        // 게임 라운드 시작
        gameRound(answerNumberList);


    }




















}

