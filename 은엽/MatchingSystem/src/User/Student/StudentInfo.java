package User.Student;

import User.User;

public class StudentInfo {
    private User[] UserStudent;

    public StudentInfo() {
        UserStudent = new User[10];
        UserStudent[0] = new User("김민수", 18, "남자", "Java", 10000);
        UserStudent[1] = new User("박지영", 12, "여자", "Python", 15000);
        UserStudent[2] = new User("최준혁", 17, "남자", "C++", 20000);
        UserStudent[3] = new User("이수민", 19, "여자", "JavaScript", 25000);
        UserStudent[4] = new User("강민호", 11, "남자", "Java", 10000);
        UserStudent[5] = new User("김지영", 9, "여자", "Python", 15000);
        UserStudent[6] = new User("박준혁", 7, "남자", "C++", 20000);
        UserStudent[7] = new User("이수민", 16, "여자", "JavaScript", 25000);
        UserStudent[8] = new User("강민호", 13, "남자", "Java", 10000);
        UserStudent[9] = new User("김지영", 19, "여자", "Python", 15000);
    }

    public User[] getUserStudent() {
        return UserStudent;
    }
}