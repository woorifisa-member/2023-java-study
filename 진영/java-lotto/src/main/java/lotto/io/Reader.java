package lotto.io;


import camp.nextstep.edu.missionutils.Console;
import lotto.Message;

import java.io.IOException;


public final class Reader {

    public Integer inputPurchaseAmount() {
        Message.PURCHASE.printMessage();
        String str = Console.readLine();
        return Integer.parseInt(str);
    }

}
