package baseball;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class Game {

    public static void playGame(){
        boolean isNotFinshed = true;
        ArrayList<Integer> arr = makeRandomNumber();
        while (isNotFinshed){
            System.out.print("숫자를 입력해주세요 : ");
            String userAnswer = camp.nextstep.edu.missionutils.Console.readLine();
            Integer[] result = checkNumber(arr,userAnswer);
            if (result[0] !=0 && result[1] ==0){
                System.out.printf("%d스트라이크",result[0]);
                System.out.println();
            }
            else if(result[0] ==0 && result[1] !=0){
                System.out.printf("%d볼",result[1]);
                System.out.println();
            }
            else{
                System.out.printf("%d볼 %d스트라이크",result[1],result[0]);
                System.out.println();
            }
            if(result[0] == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String reGame = camp.nextstep.edu.missionutils.Console.readLine();
                if(reGame.charAt(0)==1){
                    playGame();
                }
                else if(reGame.charAt(0)==2){
                    isNotFinshed=false;
                }
            }
        }
    }
    public static ArrayList<Integer> makeRandomNumber(){
        int firstNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9);
        int secondNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9);
        int thirdNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9);

        System.out.println(firstNumber);
        System.out.println(secondNumber);
        System.out.println(thirdNumber);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(firstNumber);
        arr.add(secondNumber);
        arr.add(thirdNumber);

        return arr;
    }
    public static Integer[] checkNumber(ArrayList<Integer> arr,String userAnswer) {
        int strike = 0;
        int ball =0;
        for(int i =0; i < userAnswer.length(); i++){
            if(arr.contains((int)userAnswer.charAt(i)-'0')){
                if((int)userAnswer.charAt(i)-'0' == arr.get(i)){
                    strike += 1;
                }
                else{
                    ball += 1;
                }
            }
        }
        Integer[] result = {strike,ball};
        return result;
    }

}
