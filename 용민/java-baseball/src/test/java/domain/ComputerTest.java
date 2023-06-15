package domain;



import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;



class ComputerTest {
    @Test
    void 컴퓨터_랜덤숫자_3개생성(){
        Computer computer = new Computer();
        computer.runGeneratorNumber();
        List<Integer> findNumList = computer.getNumberList();

        Assertions.assertThat(findNumList.size()).isEqualTo(3);

    }

}