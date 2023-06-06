package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void 컴퓨터_랜덤숫자_3개생성(){
        Computer computer = new Computer();
        computer.runGeneratorNumber();
        List<Integer> findNumList = computer.getNumberList();

        Assertions.assertThat(findNumList.size()).isEqualTo(3);
    }
}