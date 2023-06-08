package baseball;

import controller.GameController;
import domain.Person;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        GameController gameController = new GameController();
        gameController.gameStart();
    }
}
