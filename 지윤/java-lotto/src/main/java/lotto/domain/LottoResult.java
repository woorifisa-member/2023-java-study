package lotto.domain;

public class LottoResult {


    private static final Rank[] rankNames = Rank.values();
    private static final int[] result = new int[rankNames.length];


    private LottoResult() {
    }

    public static void calculateResult(int count, boolean bonusNum) {
        for (int i = 0; i < rankNames.length; i++) {
            if (count == rankNames[i].getCount()) {
                result[i]++;
                if (bonusNum && i == 2) result[i]--;

            }
        }
    }


    public static int[] getResult() {
        return result;
    }

    public static String formatResult(int count, int prize, Rank rank) {

        if (rank == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", count, prize, getResult()[rank.ordinal()]);
        }

        return String.format("%d개 일치 (%,d원) - %d개", count, prize, getResult()[rank.ordinal()]);
    }
}
