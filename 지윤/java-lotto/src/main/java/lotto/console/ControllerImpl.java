package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validation.Validator;

import java.util.List;

public class ControllerImpl implements Controller {
    @Override
    public long getPrice() {
        long price = Long.parseLong(Console.readLine());
        Validator.validateInputPrice(price);
        return price / Lotto.PRICE;
    }

    @Override
    public List<Integer> getWinNumber() {
        return null;
    }

    @Override
    public int getBonusNumber() {
        return 0;
    }
}
