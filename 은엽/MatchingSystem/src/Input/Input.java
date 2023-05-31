package Input;

import java.util.Scanner;

public class Input {
//	private boolean usertype = true;
	
	static Scanner sc = new Scanner(System.in);
	
	public static int isStudent() {
		Output.Output.getUserType();
		int type = sc.nextInt();
		return type;
	}
	
//	public static void getUserInfo(boolean userType) {
//		static Scanner sc = new Scanner(System.in);
//		
//		Output.Output.getUserInfo("이름");
//		String name = sc.nextLine();
//		
//		Output.Output.getUserInfo("나이");
//		int age = sc.nextInt();
//		
//		Output.Output.getUserInfo("성별(여자, 남자)");
//		String gender = sc.nextLine();
//		
//		Output.Output.getUserInfo("과목");
//		String subject = sc.nextLine();
//		
//		Output.Output.getUserInfo("시급");
//		int pay = sc.nextInt();
//		
//		if(userType) {
//			Output.Output.getUserInfo("수강 목적(0:취미반, 1:입시반)");
//			int purpose = sc.nextInt();
//
//		}else {
//			Output.Output.getUserInfo("경력");
//			int career  = sc.nextInt();
//		}
//	}
//	
//	public static void getTargetInfo(String userType) {
//		System.out.printf("원하는 %s의 %s를(을) 입력해주세요.", userType, info);
//	}
}


