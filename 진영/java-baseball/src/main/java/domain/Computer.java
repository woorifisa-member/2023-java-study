package domain;

import utils.BaseBallGenerator;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    BaseBallGenerator baseBallGenerator = new BaseBallGenerator();

    private List<Integer> numberList = new ArrayList<>(); //컴퓨터 객체만의 넘버리스트

    public void runGeneratorNumber(){
        //baseBallGenerator 생성기에서 숫자를 받아올 수 있죠?
        List<Integer> generatedList = baseBallGenerator.generateNumber();
        numberList.clear();
        for (Integer i : generatedList){
            numberList.add(i);
        }
    }

    public List<Integer> getNumberList(){
        return numberList;
    }
}
