package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {

    public static int[] inputNumber() {
        System.out.printf("숫자를 입력해주세요 :");

        String str = Console.readLine();

        if (str.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다");
        }

        int[] userNumber = new int[str.length()];


        for (int i = 0; i < str.length(); i++) {
            userNumber[i] = str.charAt(i) - '0';
        }

        return userNumber;


    }

}
