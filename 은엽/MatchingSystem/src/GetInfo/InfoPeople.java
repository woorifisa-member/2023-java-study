package GetInfo;
import Input.GetUser;
import User.Teacher.TeacherInfo;
import User.User;
import Compare.Compare;
import User.Student.StudentInfo;
public class InfoPeople {
	public static void info(int number) {

		if(number == 1) {
			TeacherInfo teacherInfo = new TeacherInfo();
			User[] UserTeacher = teacherInfo.getUserTeacher();
			System.out.println("학생 관련 정보를 입력하겠습니다.");
			String name = GetUser.userName();
			int age = GetUser.userAge();
			String gender = GetUser.userGender();
			String subject = GetUser.userSubject();
			int money = GetUser.userInt();
			User studentInfo = new User(name, age, gender, subject, money);
			Compare.calculateTeacherScore(UserTeacher, studentInfo);
		}
		else {
			StudentInfo studentInfo = new StudentInfo();
			User[] UserStudent = studentInfo.getUserStudent();
			System.out.println("강사 관련 정보를 입력하겠습니다.");
			String name = GetUser.userName();
			int age = GetUser.userAge();
			String gender = GetUser.userGender();
			String subject = GetUser.userSubject();
			int money = GetUser.userInt();
			User teacherInfo = new User(name, age, gender, subject, money);
			Compare.calculateStudentScore(UserStudent, teacherInfo);
		}
	}
}
