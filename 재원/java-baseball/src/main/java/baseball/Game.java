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
