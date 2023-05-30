package Game;

import Compare.NumberCompare;
import Number.Computer;
import Number.Human;
import camp.nextstep.edu.missionutils.Console;

public class Result {
    public static void result(){
        int endGame = 1;
        while(endGame !=2)

        {
            int[] computerNumbers = Computer.computer();
            int strike = 0;
            int ball = 0;
            while (strike < 3) {
                String[] humanNumbers = Human.getNumbers();
                int[] results = NumberCompare.compare(computerNumbers, humanNumbers);
                strike = results[0];
                ball = results[1];
                Strike.strike(strike,ball);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            endGame = Integer.parseInt(Console.readLine());
        }
    }
}
