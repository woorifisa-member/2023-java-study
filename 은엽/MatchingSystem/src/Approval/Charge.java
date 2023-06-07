package Approval;
import java.util.Scanner;
import Matching.Main;
public class Charge {
    private static int cash = 0;
    public static void charge(int money) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("바로 결재하시겠습니까? (예 : 1 아니요 : 2) ");
        int input = scanner.nextInt();
        if(input == 1){
            System.out.printf("현재 잔액은 %d 원입니다.",cash);
            System.out.print("충전할 금액을 입력하세요: ");
            int amount = scanner.nextInt();
            cash = amount + cash;
            System.out.println(amount + "원이 충전되었습니다.");
            System.out.printf("현재 잔액은 %d 원입니다.",cash);
            liquidate.makePayment(money, cash);
        }else {
            System.out.println("1주일안에 결재를 완료하여야 합니다.");
            System.out.println("프로그램을 종료합니다.");
        }
    }
    public static int getCash() {
        return cash;
    }

    public static void setCash(int value) {
        cash = value;
    }
}
