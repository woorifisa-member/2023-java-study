package domain;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Integer> numberList = new ArrayList<>();

    public void inputStringToNumber(String str) { //987
        numberList.clear();
        for (int i = 0; i < str.length(); i++) {

            String s = str.substring(i, i + 1); // 987이라는 문자열에  i번째 이상부터 i+1 미만까지
            Integer num = Integer.parseInt(s);
            numberList.add(num);


        }


    }

    public List<Integer> getNumberList() {

        return this.numberList;
    }
}
