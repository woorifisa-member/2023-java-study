package lotto.io;


import camp.nextstep.edu.missionutils.Console;
import lotto.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public final class Reader {

    public Integer inputPurchaseAmount() {
        Message.PURCHASE.printMessage();
        String str = Console.readLine();
        validateNumber(str);
        return Integer.parseInt(str);
    }

    public List<Integer> inputWinNumberList(){
        Message.SET_WIN_LOTTO.printMessage();
        List<Integer> numList = new ArrayList<>();
        String str = Console.readLine();
        for(String num : str.split(",")){
            validateNumber(num);
            numList.add(Integer.parseInt(num));
        }
        return numList;
    }

    public int inputBonusNumber(){
        Message.SET_BONUS_NUM.printMessage();
        String number = Console.readLine();
        validateNumber(number);
        return Integer.parseInt(number);
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

}
