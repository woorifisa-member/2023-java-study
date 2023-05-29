package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class BaseballGame {


  private int strike = 0;
  private int ball = 0;
  private int[] computerNumbers = new int[3];


  // 게임 플레이
  public void playGame() {
    this.computerNumbers = new int[3];
    pickUniqueRandomNum(computerNumbers);

    while (true) {
      gameInit();
      System.out.println(Arrays.toString(computerNumbers));
      System.out.print("숫자를 입력해주세요 : ");
      String[] userNumbers = Console.readLine().split("");
      if (userNumbers.length != 3) {
        throw new IllegalArgumentException("3개의 숫자를 연속으로 입력해주세요");
      }
      compareNumbers(userNumbers);
      printResult();
      if (strike == 3) {
        strikeResult();
        break;
      }

    }

  }


  // 랜덤 유티크 넘버 뽑기
  private void pickUniqueRandomNum(int[] numbers) {
    boolean[] nums = new boolean[9];
    for (int i = 0; i < 3; i++) {
      int randomNum = Randoms.pickNumberInRange(1, 9);
      while (nums[randomNum - 1]) {
        randomNum = Randoms.pickNumberInRange(1, 9);
      }
      nums[randomNum - 1] = true;
      numbers[i] = randomNum;
    }
  }

  // usernumber와 비교해서 점수 계산

  private void compareNumbers(String[] userNumbers) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        countStrikeBall(i, j, userNumbers);
      }
    }
  }

  private void countStrikeBall(int i, int j, String[] userNumbers) {
    int userNum = Integer.parseInt(userNumbers[i]);
    if (userNum == computerNumbers[j]) {
      if (i == j) {
        strike++;
      } else {
        ball++;
      }
    }
  }

  // 결과값 출력

  private void printResult() {
    if (strike > 0 && ball > 0) {
      System.out.printf("%d볼 %d스트라이크%n", ball, strike);
    } else if (strike > 0) {
      System.out.printf("%d스트라이크%n", strike);
    } else if (ball > 0) {
      System.out.printf("%d볼%n", ball);
    } else {
      System.out.println("낫싱");
    }

  }

  private void strikeResult() {
    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    boolean isRestart = isRestartGame();
    if (isRestart) {
      playGame();
    }
  }

  private boolean isRestartGame() {
    int select = Integer.parseInt(Console.readLine());
    boolean isRestart;
    if (select != 1 && select != 2) {
      throw new IllegalArgumentException("1과 2 둘중에 하나만 입력해주세요");
    }
    if (select == 1) {
      isRestart = true;
    } else {
      isRestart = false;
    }
    return isRestart;
  }

  // 게임 초기화
  private void gameInit() {
    this.strike = 0;
    this.ball = 0;
  }

}
