package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IOException {
        //TODO: 숫자 야구 게임 구현
    	int isContinue = 1;
    	
    	while(isContinue != 2) {
	    	int done = 0;
	    	Integer[] computer_number = Computer.computer();
	    	
	    	while (done != 3) {
	    		int[] user_number = InputNumber.inputNumber();
	    		done = Compare.compare(user_number, computer_number);
	    	}

			System.out.printf("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

			isContinue = Integer.parseInt(Console.readLine());

		}
    	
    }
}
