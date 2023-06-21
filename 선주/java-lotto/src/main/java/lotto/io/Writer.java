package lotto.io;

public final class Writer {

    private Writer() {

    }

    public static void print(String s) {
        write(s, false);
    }

    public static void print(Object o) {
        print(o.toString());
    }

    public static void println(String s) {
        write(s, true);
    }

    public static void println(Object o) {
        println(o.toString());
    }

    private static void write(String s, boolean newLine) {
        if (newLine) {
            System.out.println(s);
        } else {
            System.out.print(s);
        }
    }

}