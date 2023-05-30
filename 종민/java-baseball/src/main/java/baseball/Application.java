package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static int getHundereds(int num){
        return num / 100;
    }
    public static int getTens(int num){
        return (num % 100) / 10;
    }
    public static int getUnits(int num){
        return num % 10 ;
    }

    public static void compareNum(int ranNum, int num){
        int isdone = 0;
        int ranHuns = getHundereds(ranNum);
        int ranTens = getTens(ranNum);
        int ranUnits = getUnits(ranNum);

        int numHuns = getHundereds(num);
        int numTens = getTens(num);
        int numUnits = getUnits(num);

        int cntStrike = 0;
        int cntBall = 0;

        if (ranHuns == numHuns){
            cntStrike++;
        } else if (ranHuns == numTens) {
            cntBall++;
        } else if (ranHuns == numUnits) {
            cntBall++;
        }
        if (ranTens == numTens){
            cntStrike++;
        } else if (ranTens == numHuns) {
            cntBall++;
        } else if (ranTens == numUnits) {
            cntBall++;
        }
        if (ranUnits == numUnits){
            cntStrike++;
        } else if (ranUnits == numHuns) {
            cntBall++;
        } else if (ranUnits == numTens) {
            cntBall++;
        }
        if(cntStrike == 0 && cntBall ==0){
            System.out.println("낫싱");
        }
        else if(cntBall == 0){
            System.out.println(cntStrike + "스트라이크");
        } else if (cntStrike == 0) {
            System.out.println(cntBall + "볼");
        }  else {
            System.out.println(cntBall + "볼 " + cntStrike + "스트라이크");
        }
        if(cntStrike == 3){
            isdone = 3;
        }

    }
    public static void main(String[] args) throws IOException {
        //TODO: 숫자 야구 게임 구현

            int ranNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(100, 1000);

                System.out.print("숫자를 입력해주세요 : ");
                int num = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
                compareNum(ranNum, num);

    }
}