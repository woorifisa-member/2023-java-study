package lotto.console;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class UserInput implements Controller {
    /**
     * 사용자가 구매할 로또의 가격을 입력받는다.
     *
     * @return 사용자가 구매할 로또 수량
     */
    public long getPrice() {
        long price = Long.parseLong(Console.readLine());
        return price;
    }

    /**
     * 당첨번호를 입력받는다.
     *
     * @return 당첨번호 목록
     */
    public List<Integer> getWinNumber() {
        // TODO 컬렉션 프레임워크 공부 후 리팩토링 해보기
        List<Integer> winNumList = new ArrayList<>();
        // 사용자 입력 받기 (String[] 타입으로)
        String winNumInput = Console.readLine();
        String[] winNumStrLsit = winNumInput.split(",");
        // String[] -> List<Integer> 변환
        for (int i = 0; i < winNumStrLsit.length; i++) {
            winNumList.add(Integer.parseInt(winNumStrLsit[i]));
        }
        return winNumList;
    }

    /**
     * 보너스 번호를 입력받는다.
     *
     * @return 보너스 번호
     */
    public int getBonusNumber() {
        int bonusNum = Integer.parseInt(Console.readLine());
        return bonusNum;
    }
}

