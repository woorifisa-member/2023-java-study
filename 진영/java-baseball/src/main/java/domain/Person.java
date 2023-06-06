package domain;

import utils.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Person {
    private List<Integer> numberList = new ArrayList<>();
    private InputValidator inputValidator = new InputValidator();

    public void saveNumber(String str) {
        inputValidator.checkInputNumber(str);
        numberList.clear();

        numberList = range(0, str.length())
                .mapToObj(i -> parseInt(String.valueOf(str.charAt(i))))
                .collect(toList());
    }

    public List<Integer> getNumberList() {
        return this.numberList;
    }

}
