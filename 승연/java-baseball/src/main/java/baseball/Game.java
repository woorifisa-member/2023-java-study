package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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
        String input = Console.readLine();
    }



















}

