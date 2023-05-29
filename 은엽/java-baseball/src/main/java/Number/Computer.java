package Number;
import java.util.Random;
public class Computer {
    private int[] computerNumbers = new int[3];

    public int[] computer() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            computerNumbers[i] = random.nextInt(9) + 1;
            for (int j = 0; j < i; j++) {
                if (computerNumbers[i] == computerNumbers[j]) {
                    i--;
                }
            }
            System.out.println(computerNumbers[i]);
        }
        return computerNumbers;
    }
}
