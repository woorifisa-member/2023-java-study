package lotto.console;

import lotto.io.Reader;
import lotto.io.Writer;
import lotto.validation.Validator;

import java.util.List;

public class HelloControllerImpl implements Controller {
    @Override
    public long getPrice() {
        Writer.println("구입금액을 입력해 주세요.");
        long price = Integer.parseInt(Reader.read());

        Validator.validatePrice(price);

        return price;
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
