package controller;

import domain.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class GameControllerTest {

    GameController gameController;

    @Test
    void 숫자3개_입력받아_저장하기() {
        Person person = new Person();
        String str = "987";
        person.saveNumber(str);

        List<Integer> findList = person.getNumberList();
        for (int i = 0; i < findList.size(); i++) {
            Assertions.assertThat(str.substring(i,i+1)).isEqualTo(findList.get(i).toString());
        }
    }
}