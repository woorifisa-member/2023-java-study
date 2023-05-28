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
    }
  }

  void matchNumbers(List<Integer> computerRandom, String[] userNumbers) throws IllegalArgumentException {
    for(int i = 0; i < 3; i++) {
      int inputNum = Integer.parseInt(userNumbers[i]);
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

}
