package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validation.Validator;

public class ControllerImpl implements Controller {

    @Override
    public long getPrice() {
        return Validator.validatePriceInput(Console.readLine());
    }

    @Override
    public List<Integer> getWinNumber() {
        return Validator.validateWinNumberInput(Console.readLine());
    }

    @Override
    public int getBonusNumber() {
        return Validator.validateBonusNumberInput(Console.readLine());
    }

}
