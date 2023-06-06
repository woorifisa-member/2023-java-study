package baseball;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void playGame () {
        boolean isNotFinshed = true;
        ArrayList<Integer> randomNumberArr = makeRandomNumber();
        while (isNotFinshed){
            System.out.print("숫자를 입력해주세요 : ");
            String userAnswer = Console.readLine();
            if(userAnswer.length() !=3){
                throw new IllegalArgumentException("3개의 숫자를 입력해주세요");
            }
            int[] result = checkNumber(randomNumberArr,userAnswer);
            if (result[0] !=0 && result[1] ==0){
                System.out.printf("%d스트라이크",result[0]);
                System.out.println();
            }
            else if(result[0] ==0 && result[1] !=0){
                System.out.printf("%d볼",result[1]);
                System.out.println();
            }
            else if(result[0] ==0 && result[1] ==0){
                System.out.println("낫싱");
            }
            else{
                System.out.printf("%d볼 %d스트라이크",result[1],result[0]);
                System.out.println();
            }
            if(result[0] == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String reGame = Console.readLine();
                if(reGame.charAt(0)=='1'){
                    playGame();
                }
                else if(reGame.charAt(0)=='2'){
                    isNotFinshed=false;
                }
            }
        }
    }
    public static ArrayList<Integer> makeRandomNumber() {
        ArrayList<Integer> randomNumberArr = new ArrayList<>();

        while(randomNumberArr.size() <3){
            int number = Randoms.pickNumberInRange(1,9);
            if(!randomNumberArr.contains(number)){
                randomNumberArr.add(number);
            }

        }
        return randomNumberArr;
    }
    public static int[] checkNumber(ArrayList<Integer> randomNumberArr,String userAnswer)  {
        int[] result = new int[2];
        for(int i =0; i < userAnswer.length(); i++){
            checkSB(randomNumberArr,userAnswer,result,i);
        }
        return result;
    }
    public static void checkSB(ArrayList<Integer> randomNumberArr,String userAnswer, int[] result,int i){
        if(randomNumberArr.contains((int)userAnswer.charAt(i)-'0')){
            if((int)userAnswer.charAt(i)-'0' == randomNumberArr.get(i)){
                result[0] += 1;
            }
            else{
                result[1] += 1;
            }
        }
    }

}
