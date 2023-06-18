package lotto.console;

import lotto.io.Reader;
import lotto.io.Writer;
import lotto.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class HelloControllerImpl implements Controller {
    @Override
    public long getPrice() {
        Writer.println("구입금액을 입력해 주세요.");
        long price = Validator.validatePrice(Reader.read());

        return price;
    }

    @Override
    public List<Integer> getWinNumber() {
        Writer.println("\n당첨 번호를 입력해 주세요.");
        String input = Reader.read();

        String[] strNumbers = input.split(",");

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < strNumbers.length; i++){
            int num = Validator.validateNumber(strNumbers[i]);
            numbers.add(num);
        }
        numbers = Validator.validateLottoLength(numbers);
        numbers = Validator.validateDuplication(numbers);

        return numbers;
    }

    @Override
    public int getBonusNumber() {
        Writer.println("");
        Writer.println("보너스 번호를 입력해 주세요.");

        return Validator.validateNumber(Reader.read());
    }
}
