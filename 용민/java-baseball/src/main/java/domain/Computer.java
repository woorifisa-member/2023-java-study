package domain;

import utils.BaseBallGenerator;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    BaseBallGenerator baseBallGenerator = new BaseBallGenerator();

    private List<Integer> numberList = new ArrayList<>();//컴퓨터 객체 넘버리스트

    public void runGeneratorNumber() {
        List<Integer> generatedList = baseBallGenerator.generateNumber();

       for(Integer i : generatedList) {
         numberList.add(i);
       }

    }

    public List<Integer> getNumberList() {
        return numberList;
    }

}
