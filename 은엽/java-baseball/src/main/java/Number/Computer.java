package Number;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Computer {
    private static int[] computerNumbers = new int[3];

    public static int[] computer() {
        Set<Integer> generatedNumbers = new HashSet<>();
        for (int i = 0; i < 3; ) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumbers.contains(number)) {
                computerNumbers[i] = number;
                generatedNumbers.add(number);
                i++;
            }
        }
        return computerNumbers;
    }
}
