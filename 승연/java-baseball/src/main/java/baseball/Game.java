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

    public void gameStart(){
        System.out.print(inputMessage);
        String tmp = Console.readLine();

        try{
            // 문자 입력 예외처리 // 고의 에러 발생이 아닐 경우 예외처리 메시지 ?
            int input = Integer.parseInt(tmp);
            // 세자릿수보다 작은 수가 입력된 경우 예외처리
            if ((int)(Math.log10(input)+1) < 3){
                throw new IllegalArgumentException("세자릿수보다 작은 값을 입력할 수 없습니다.");
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
        }
    }



















}

