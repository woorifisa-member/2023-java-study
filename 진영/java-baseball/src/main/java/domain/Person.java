package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Person {
    private List<Integer> numberList = new ArrayList<>();

    public void inputStringToNumber(String str) { //987
        numberList.clear();
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            Integer num = Integer.parseInt(s);
            numberList.add(num);
        }
//        numberList = IntStream.range(0,str.length())
//                .mapToObj( i -> Integer.parseInt(String.valueOf(str.charAt(i))))
//                .collect(Collectors.toList());
    }

    public List<Integer> getNumberList(){
        return this.numberList;
    }

}
