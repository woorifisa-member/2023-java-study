package Number;
import camp.nextstep.edu.missionutils.Console;
public class Human {
    private static String[] humanNumbers = new String[3];
    public static String[] getNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String[] input = Console.readLine().split("");
        if (input.length != 3) {
            throw new IllegalArgumentException("3자리 숫자만 입력해주세요");

        }else{
            humanNumbers = input;
        }
        return humanNumbers;
    }
}
