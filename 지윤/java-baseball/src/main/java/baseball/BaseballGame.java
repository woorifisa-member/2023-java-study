package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BaseballGame {
  int strike = 0;
  int ball = 0;
  List<Integer> computerRandom;
  void playGame() throws IllegalArgumentException {
    computerRandom =  Randoms.pickUniqueNumbersInRange(1,9,3);
    while(true) {
      strike = 0;
      ball = 0;
      System.out.print("숫자를 입력해주세요 : ");
      String[] userNumbers = Console.readLine().split("");
      matchNumbers(computerRandom,userNumbers);
      gameResult();
      if(strike == 3) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int inputNextStep = Integer.parseInt(Console.readLine());
        if(inputNextStep != 1 && inputNextStep != 2) {
          exceptionGameSet("1과 2 둘 중 하나만 입력해주세요");
        }
        if(inputNextStep == 1) {
          playGame();
        } else {
          break;
        }
      }
    }
  }

  void matchNumbers(List<Integer> computerRandom, String[] userNumbers) throws IllegalArgumentException {
    if(userNumbers.length != 3) {
      exceptionGameSet("3개의 숫자를 연속으로 입력 해주세요");
    }
    for(int i = 0; i < 3; i++) {
      int inputNum = Integer.parseInt(userNumbers[i]);
      if(inputNum == 0) {
        exceptionGameSet("1 - 9 사이의 값만 입력할 수 있습니다");
      }
      for(int j = 0; j < 3; j++) {
        if(computerRandom.get(j) != inputNum) {
          continue;
        }
        if(i == j) {
          strike += 1;
        } else {
          ball += 1;
        }
      }
    }
  }

  void gameResult() {
    if(strike == 0 && ball > 0) {
      System.out.printf("%d볼%n",ball);
    } else if(ball == 0 && strike > 0) {
      System.out.printf("%d스트라이크%n",strike);
    } else if(ball > 0 && strike > 0) {
      System.out.printf("%d볼 %d스트라이크%n",ball, strike);
    } else {
      System.out.println("낫싱");
    }
  }
  void exceptionGameSet(String errorMessage) {

    throw new IllegalArgumentException(errorMessage);
  }

}
