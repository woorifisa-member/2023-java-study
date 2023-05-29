package baseball;

import java.util.*;

public class Computer {
	
	public static Integer[] main() {
		
		Set<Integer> setNumber = new HashSet<>();
		
		while(setNumber.size() < 3) {
			int number = new Random().nextInt(9) + 1;
			setNumber.add(number);
		}
		
		Integer[] computerNumber = setNumber.toArray(new Integer[setNumber.size()]);
//		System.out.println(Arrays.toString(computerNumber));
		return computerNumber;
		
	}

}
