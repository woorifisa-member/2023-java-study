package User.Teacher;
import User.User;
public class TeacherInfo {
	private User[] UserTeacher;
	public TeacherInfo() {
		UserTeacher = new User[10];
		UserTeacher[0] = new User("윤동열", 30, "남자", "Python", 10000);
		UserTeacher[1] = new User("정민성", 25, "여자", "Java", 9000);
		UserTeacher[2] = new User("백재원", 40, "남자", "C++", 12000);
		UserTeacher[3] = new User("박지윤", 35, "여자", "JavaScript", 8000);
		UserTeacher[4] = new User("이준희", 50, "남자", "Ruby", 15000);
		UserTeacher[5] = new User("임예지", 20, "여자", "Python", 7000);
		UserTeacher[6] = new User("정주영", 35, "남자", "Java", 9000);
		UserTeacher[7] = new User("정경연", 40, "여자", "C++", 12000);
		UserTeacher[8] = new User("박진영", 55, "남자", "JavaScript", 8000);
		UserTeacher[9] = new User("이소민", 25, "여자", "Python", 7000);
	}
	public User[] getUserTeacher() {
		return UserTeacher;
	}

}
