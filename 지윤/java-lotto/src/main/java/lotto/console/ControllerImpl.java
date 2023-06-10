package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.Writer;
import lotto.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    @Override
    public long getPrice() {
        Writer.print("발행할 로또의 금액을 1000원 단위로 입력해주세요 : ");
        long price = Long.parseLong(Console.readLine());
        Validator.validateInputPrice(price);
        return price;
    }

    @Override
    public List<Integer> getWinNumber() {
        List<Integer> winNumbers = new ArrayList<>();
        Writer.print("당첨 로또 번호 6개를(1~45) 쉼표로 구분하여 입력해주세요 : ");
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
        Writer.print("보너스번호 1개를 입력해주세요 : ");
        int bonusNumber = Integer.parseInt(Console.readLine());
        Validator.validateInputBonusNumber(bonusNumber, winNumber);
        return bonusNumber;
    }
}
