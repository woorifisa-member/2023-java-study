package Output;

public class Output {
	public static void greeting() {
		System.out.println("학생-강사 매칭 프로그램 시작");
	}
	
	public static void getUserType() {
		System.out.println("당신은? 1: 학생, 2: 선생님");
	}

	public static void getMyInfo(String info) {
		System.out.printf("당신의 %s를(을) 입력해주세요.\n", info);
	}
	public static void getUserInfo(String info) {
		System.out.printf("원하는 %s를(을) 입력해주세요.\n", info);
	}
	
	public static void getTargetInfo(String info, String userType) {
		System.out.printf("원하는 %s의 %s를(을) 입력해주세요.", userType, info);
	}
	
	public static void goodBye() {
		System.out.printf("프로그램 종료. 이용해주셔서 감사합니다.\n");
	}
	
}
