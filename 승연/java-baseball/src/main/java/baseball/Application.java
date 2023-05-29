package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Game game = new Game();
        game.gameStart();

    }
}
