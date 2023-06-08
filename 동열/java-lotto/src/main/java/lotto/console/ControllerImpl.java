package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validation.Validator;

public class ControllerImpl implements Controller {

    @Override
    public long getPrice() {
        return Validator.validPriceInput(Console.readLine());
    }

    @Override
    public List<Integer> getWinNumber() {
        return Validator.validWinNumberInput(Console.readLine());
    }

    @Override
    public int getBonusNumber() {
        return 0;
    }

}
