package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGenerator implements NumberGenerator{
    @Override
    public List<Integer> generateNumber() {
        List<Integer> numList = new ArrayList<>();
        while (numList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9); //1~9까지
            if (!numList.contains(randomNumber)) { //   중복제거
                numList.add(randomNumber);
            }
        }

        return numList;
    }
}
