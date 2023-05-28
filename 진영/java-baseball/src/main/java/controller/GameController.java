package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Computer;
import domain.Person;
import utils.BaseBallGenerator;
import utils.BaseBallNumberValidator;
import utils.InputValidator;
import view.InputView;

import java.util.List;

public class GameController {
    private Person person;
    private Computer computer;
    private BaseBallNumberValidator validator;
    private InputView inputView;

    public GameController() {
        this.person = new Person();
        this.computer = new Computer();
        this.validator = new BaseBallNumberValidator();
        this.inputView = new InputView();
    }

    public void gameStart() {
        gameProgress();
        checkRestart();
    }
    public void computerInit() {
        computer.runGeneratorNumber();
        List<Integer> aiNumberList = computer.getNumberList(); //컴퓨터 숫자
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void gameProgress(){
        computerInit();
        while (true) {
            person.saveNumber(inputView.inputNumber());
            List<Integer> personNumberList = person.getNumberList(); //나의 숫자
            List<Integer> aiNumberList = computer.getNumberList();
            boolean resultTag = validator.checkInningResult(aiNumberList, personNumberList);

            if (resultTag) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
    public void checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String str = Console.readLine();
        if (str.equals("1")) {
            gameStart();
        } else if (str.equals("2")) {
            return;
        }
    }
}
