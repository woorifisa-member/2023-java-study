package baseball;

public class Application {

    public static void main(String[] args) {
        BaseballGame baseball = new BaseballGame();
        try{
            baseball.playGame();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
    }
}
