package utils;

public class InputValidator {
    public void checkInputNumber(String str) {
        if(str.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
