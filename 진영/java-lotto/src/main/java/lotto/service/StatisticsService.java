package lotto.service;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinLotto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StatisticsService {

    private final Map<Rank, Integer> map;

    public StatisticsService() {
        map = new LinkedHashMap<>();
    }

    public Map<Rank, Integer> compileStatistics(IssuedLotto issuedLotto, WinLotto winLotto) {
        List<Lotto> lottoList = issuedLotto.getLottoList();
        map.clear();
        initMap();
        for (Lotto lotto : lottoList) {
            Rank rank = Rank.getRank(lotto, winLotto);
            if (rank != null) {
                saveRank(rank);
            }
        }
        return map;
    }

    public void saveRank(Rank rank) {
        map.put(rank,map.getOrDefault(rank,0)+1);
    }

    public void initMap() {
        for (Rank rank : Rank.values()) {
            map.put(rank, 0);
        }
    }
}
