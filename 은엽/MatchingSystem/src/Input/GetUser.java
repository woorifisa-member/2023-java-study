package Input;

import java.util.*;


import java.util.*;

public class GetUser {
	static Scanner sc = new Scanner(System.in);

	public static String userName() {
		Output.Output.getMyInfo("이름");
		String name = sc.next();
		return name;
	}

	public static int userAge() {
		Output.Output.getUserInfo("나이");
		int age = sc.nextInt();
		return age;
	}

	public static String userGender() {
		Output.Output.getUserInfo("성별(여자, 남자)");
		String gender = sc.next();
		return gender;
	}

	public static String userSubject() {
		Output.Output.getUserInfo("과목");
		String subject = sc.next();
		return subject;
	}

	public static int userInt() {
		Output.Output.getUserInfo("시급");
		int pay = sc.nextInt();
		return pay;
	}

	public static int studentPurpose() {
		Output.Output.getUserInfo("수강 목적(0:취미반, 1:입시반)");
		int purpose = sc.nextInt();
		return purpose;
	}

	public static int TeacherCareer() {
		Output.Output.getUserInfo("경력");
		int career  = sc.nextInt();
		return career;
	}
}
