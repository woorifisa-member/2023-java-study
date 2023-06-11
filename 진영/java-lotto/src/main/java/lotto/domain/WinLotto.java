package lotto.domain;

public class WinLotto {

    private final Lotto WinLotto;
    private final int bonusNumber;

    public WinLotto(Lotto winLotto, int bonusNumber) {
        WinLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(int number){
       return WinLotto.contains(number);
    }

    public int getBonus(){
        return bonusNumber;
    }

}
