package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
	
	public static Integer[] computer() {
		
		Set<Integer> setNumber = new HashSet<>();
		
		while(setNumber.size() < 3) {
			int number = Randoms.pickNumberInRange(1, 9);
			setNumber.add(number);
		}
		
		Integer[] computerNumber = setNumber.toArray(new Integer[setNumber.size()]);
//		System.out.println(Arrays.toString(computerNumber));
		return computerNumber;
		
	}

}
