package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        //TODO: 숫자 야구 게임 구현
    	int isContinue = 1;
    	
    	while(isContinue != 2) {
	    	int done = 0;
	    	Integer[] computer_number = Computer.main();
	    	
	    	while (done != 3) {
	    		int[] user_number = InputNumber.main();
	    		done = Compare.main(user_number, computer_number);
	    	}
	    	
	    	if (done == 3) {
	    		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	    		
	    		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	            
	    		isContinue = Integer.parseInt(reader.readLine());
	     
	    	}
    	}
    	
    }
}
