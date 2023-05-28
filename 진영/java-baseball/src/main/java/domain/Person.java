package domain;

import utils.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Person {
    private List<Integer> numberList = new ArrayList<>();
    private InputValidator inputValidator = new InputValidator();

    public void saveNumber(String str) {
        inputValidator.checkInputNumber(str);
        numberList.clear();

        numberList = IntStream.range(0, str.length())
                .mapToObj(i -> Integer.parseInt(String.valueOf(str.charAt(i))))
                .collect(Collectors.toList());
    }

    public List<Integer> getNumberList() {
        return this.numberList;
    }

}
