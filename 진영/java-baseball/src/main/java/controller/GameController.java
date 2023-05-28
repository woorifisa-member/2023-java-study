package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.Person;

public class GameController {

    Person person;
    public GameController(){
        this.person = new Person();
    }
    public void gameStart(){
        System.out.print("숫자를 입력해주세요 :");
        String str = Console.readLine(); // 987

        Person person = this.person;
        person.inputStringToNumber(str);

    }
}
