package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoIssueService {
    public Lotto issueLotto() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        while (numbers.size() < 6) {
            int number = random.nextInt(45) + 1;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        return new Lotto(numbers);
    }
}