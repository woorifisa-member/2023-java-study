package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Computer;
import domain.Person;
import utils.BaseBallGenerator;
import utils.BaseBallNumberValidator;

import java.util.List;

public class GameController {

    Person person;
    Computer computer;
    BaseBallNumberValidator validator;
    public GameController(){
        this.person = new Person();
        this.computer = new Computer();
        this.validator = new BaseBallNumberValidator();
    }
    public void gameStart(){
        computer.runGeneratorNumber();
        List<Integer> aiNumberList = computer.getNumberList(); //컴퓨터 숫자

        while(true){
            System.out.print("숫자를 입력해주세요 :");
            String str = Console.readLine();
            System.out.println();

            person.inputStringToNumber(str);
            List<Integer> personNumberList = person.getNumberList(); //나의 숫자

            Boolean resultTag = validator.checkInningResult(aiNumberList,personNumberList);

            if(resultTag){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

        }
    }

}
