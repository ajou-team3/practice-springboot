package ajou.realcoding.team3.riotGamesPerformances.service;

import ajou.realcoding.team3.riotGamesPerformances.api.RiotGamesPerformancesAPIClient;
import ajou.realcoding.team3.riotGamesPerformances.domain.PlayerEncryptedID;
import ajou.realcoding.team3.riotGamesPerformances.domain.PlayerPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    RiotGamesPerformancesAPIClient riotGamesPerformancesAPIClient;

    public PlayerEncryptedID getEncryptedIdBySummonerName(String summonerName) {
        return riotGamesPerformancesAPIClient.requestEncryptedID(summonerName);
    }

    public PlayerPerformance getPerformanceByEncryptedSummonerID(String encryptedID) {
        return null;
    }
}
