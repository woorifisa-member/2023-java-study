package lotto;

public enum Message {
    PURCHASE("구입금액을 입력해 주세요."),
    SET_WIN_LOTTO("당첨 번호를 입력해 주세요."),
    SET_BONUS_NUM("보너스 번호를 입력해 주세요");

    private final String message;

    Message(String str) {
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void printMessage() {
        System.out.println(getMessage());
    }

}
