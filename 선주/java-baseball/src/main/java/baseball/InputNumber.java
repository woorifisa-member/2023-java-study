package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InputNumber {

	public static int[] inputNumber() throws IOException {
		System.out.printf("숫자를 입력해주세요 :");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        
        if (str == null || str.length() != 3) {
        	 throw new IllegalArgumentException("잘못된 값을 입력했습니다");
		}else {
        	
        	int[] userNumber = new int[str.length()];
        	
        	
            for (int i = 0; i < str.length(); i++) {
            	userNumber[i] = str.charAt(i) - '0';
            }
            
        	return userNumber;
        }

	}

}
