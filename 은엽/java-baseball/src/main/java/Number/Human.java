package Number;

import java.util.Scanner;
import java.util.InputMismatchException;
public class Human {
    private int[] humanNumbers = new int[3];
    public int[] getNumbers() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("3자리의 숫자를 입력하세요.");
            int input = scanner.nextInt();
            if (input < 100 || input > 999) {
                throw new IllegalArgumentException("숫자가 3자리가 아닙니다.");
            }
            humanNumbers[0] = input / 100;
            humanNumbers[1] = (input % 100) / 10;
            humanNumbers[2] = input % 10;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
            System.exit(0);
        }
        return humanNumbers;
    }
}
