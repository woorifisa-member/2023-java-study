package Compare;
import User.User;
import java.util.Scanner;
import Matching.Main;
import Approval.Charge;
public class Compare {
    public static void calculateTeacherScore(User[] UserTeacher, User studentInfo) {
        Scanner in = new Scanner(System.in);
        int[] scores = new int[UserTeacher.length];
        int maxValue = 0;
        int state = 0;
        for (int i = 0; i < UserTeacher.length; i++) {
//            if (UserTeacher[i].getName().equals(studentInfo.getName())) {
//                scores[i] += 20;
//            }
            if(UserTeacher[i].getAge() >= studentInfo.getAge()) {
                scores[i] += 20;
            }
            if(UserTeacher[i].getGender().equals(studentInfo.getGender())){
                scores[i] += 20;
            }
            if (UserTeacher[i].getPreferred_programming_language().equals(studentInfo.getPreferred_programming_language())) {
                scores[i] += 20;
            }
            if(UserTeacher[i].getHourly_wage() <= studentInfo.getHourly_wage()){
                scores[i] += 20;
            }
        }
        for(int j = 0; j < scores.length; j++){
            if (scores[j] > maxValue) {
                maxValue = scores[j]; // 현재 요소가 최대값보다 크면 최대값을 업데이트
                state = j;
            }
        }
        if(maxValue >= 40){
            System.out.println("매칭되었습니다.");
            System.out.print(studentInfo.getName() + "님이 매칭된 선생님의 정보입니다.");
            System.out.printf("이름 : %s\n나이 : %d\n성별 : %s\n언어 : %s\n시급 : %d\n",UserTeacher[state].getName(),UserTeacher[state].getAge(),UserTeacher[state].getGender(),UserTeacher[state].getPreferred_programming_language(),UserTeacher[state].getHourly_wage());
            System.out.println("강사와 매칭하시겠습니까? (예 : 1, 아니오 : 2)");
            int next = in.nextInt();
            if(next == 1){
                Main.again = 1;
                System.out.println("강사와 매칭되었습니다.");
                Charge.charge(UserTeacher[state].getHourly_wage());
            }else{
                Main.again = 2;
                System.out.println("재매칭 하겠습니다.");
            }
        }else{
            System.out.println("매칭된 선생님이 없습니다.");
            Main.again = 2;
            System.out.println("재매칭 하겠습니다.");
        }
    }

    public static void calculateStudentScore(User[] UserStudent, User teacherInfo) {
        Scanner in = new Scanner(System.in);
        int[] scores = new int[UserStudent.length];
        int maxValue = 0;
        int state = 0;
        for (int i = 0; i < UserStudent.length; i++) {
            if(UserStudent[i].getAge() <= teacherInfo.getAge()) {
                scores[i] += 20;
            }
            if(UserStudent[i].getGender().equals(teacherInfo.getGender())){
                scores[i] += 20;
            }
            if (UserStudent[i].getPreferred_programming_language().equals(teacherInfo.getPreferred_programming_language())) {
                scores[i] += 20;
            }
            if(UserStudent[i].getHourly_wage() >= teacherInfo.getHourly_wage()){
                scores[i] += 20;
            }
        }
        for(int j = 0; j < scores.length; j++){
            if (scores[j] > maxValue) {
                maxValue = scores[j]; // 현재 요소가 최대값보다 크면 최대값을 업데이트
                state = j;
            }
        }
        if(maxValue >= 40){
            System.out.println("매칭되었습니다.");
            System.out.print(teacherInfo.getName() + "님이 매칭된 학생의 정보입니다. : ");
            System.out.println("이름 : " + UserStudent[state].getName() + " 나이 : " + UserStudent[state].getAge() + " 성별 : " + UserStudent[state].getGender() + " 언어 : " + UserStudent[state].getPreferred_programming_language() + " 시급 : " + UserStudent[state].getHourly_wage() );
            System.out.println("강사와 매칭하시겠습니까? (예 : 1, 아니오 : 2)");
            int next = in.nextInt();
            if(next == 1){
                Main.again = 1;
                System.out.println("학생과 매칭되었습니다.");
            }else{
                Main.again = 2;
                System.out.println("재매칭 하겠습니다.");
            }
        }else{
            System.out.println("매칭된 학생이 없습니다.");
        }

    }
}
