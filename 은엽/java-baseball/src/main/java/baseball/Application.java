package baseball;
import Compare.NumberCompare;
import Number.Computer;
import Number.Human;

public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        Human human = new Human();
        NumberCompare numberCompare = new NumberCompare();
        int[] computerNumbers = computer.computer();
        int[] humanNumbers = human.getNumbers();
        int[] results = numberCompare.compare(computerNumbers, humanNumbers);
        System.out.println(results[0] + " " + results[1]);
    }

//    public static String[] compare(int[] computerNumbers, int[] humanNumbers) {
//        String[] results = new String[2];
//        int count = 0;
//        for (int i = 0; i < computerNumbers.length; i++) {
//            if (computerNumbers[i] == humanNumbers[i]) {
//                count++;
//            }
//        }
//        results[0] = "Computer: " + count;
//        results[1] = "Human: " + (humanNumbers.length - count);
//        return results;
//    }

}