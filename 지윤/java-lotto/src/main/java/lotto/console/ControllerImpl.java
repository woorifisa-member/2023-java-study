package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.Writer;
import lotto.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    @Override
    public long getPrice() {
        Writer.println("구입금액을 입력해 주세요.");
        String inputPrice = Console.readLine();
        Validator.validateInputPrice(inputPrice);
        return Long.parseLong(inputPrice);
    }

    @Override
    public List<Integer> getWinNumber() {
        List<Integer> winNumbers = new ArrayList<>();
        Writer.println("당첨 번호를 입력해 주세요.");
        String inputNumbers = Console.readLine();
        Validator.validateInputWinNumber(inputNumbers);
        for(String num : inputNumbers.split(",")) {
            int parsedNum = Integer.parseInt(num);
            winNumbers.add(parsedNum);
        }
        return winNumbers;
    }

    @Override
    public int getBonusNumber(List<Integer> winNumber) {
        Writer.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        Validator.validateInputBonusNumber(bonusNumber, winNumber);
        return bonusNumber;
    }
}
