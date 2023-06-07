package Approval;
import Matching.Main;

import java.util.Scanner;
public class liquidate {
    public static void makePayment(int money, int cash) {
        int pay = 0;
        Scanner in = new Scanner(System.in);

        int dailyEarnings = money * 8;
        System.out.print("1주일에 필요한 과외 횟수를 입력하세요: ");
        int weeklySessions = in.nextInt();

        int monthlyEarnings = dailyEarnings * weeklySessions * 4;
        int remainingBalance = cash - monthlyEarnings;
        while(pay != 1){
            if (cash-monthlyEarnings < 0) {
                System.out.println("현재 금액이 부족합니다.");
                System.out.print("충전할 금액을 입력하세요: ");
                int rechargeAmount = in.nextInt();

                cash += rechargeAmount;
                remainingBalance = cash - monthlyEarnings;

                if (remainingBalance >= 0) {
                    System.out.println("충전이 완료되었습니다.");
                    pay = 1;
                } else {
                    System.out.println("충전 후에도 금액이 부족합니다.");
                }
            }else {
                System.out.println("결재 완료되었습니다.");
                break;
            }

        }
        System.out.println("일주일의 과외 횟수는 " + weeklySessions + "번입니다.");
        System.out.println("남은 금액은 " + remainingBalance + "원입니다.");
        Charge.setCash(remainingBalance);
        System.out.println("새로운 강사를 찾으시겠습니까? (예 : 1 아니요 : 2) ");
        int newTeacher = in.nextInt();
        if(newTeacher == 1){
            Main.again = 2;
        }
        else{
            Main.again = 1;
        }
    }
}
