package ajou.realcoding.team3.riotGamesPerformances.service;

import ajou.realcoding.team3.riotGamesPerformances.api.RiotGamesPerformancesAPIClient;
import ajou.realcoding.team3.riotGamesPerformances.domain.PlayerEncryptedID;
import ajou.realcoding.team3.riotGamesPerformances.domain.PlayerPerformance;
import ajou.realcoding.team3.riotGamesPerformances.repository.CurrentPerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    RiotGamesPerformancesAPIClient riotGamesPerformancesAPIClient;
    @Autowired
    CurrentPerformanceRepository currentPerformanceRepository;

    public PlayerEncryptedID getEncryptedIdBySummonerName(String summonerName) {
        return riotGamesPerformancesAPIClient.requestEncryptedID(summonerName);
    }

    public List<PlayerPerformance> getPerformanceByEncryptedSummonerID(String encryptedID) {
        currentPerformanceRepository.manageCurrentPerformance(riotGamesPerformancesAPIClient.requestPerformance(encryptedID));
        return currentPerformanceRepository.findCurrentPerformance(encryptedID);
    }
}
