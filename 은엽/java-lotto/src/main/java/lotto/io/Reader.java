package lotto.io;

import java.util.Scanner;

public class Reader {
    private final Scanner scanner;

    public Reader() {
        scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }
}