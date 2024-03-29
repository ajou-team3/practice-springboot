package ajou.realcoding.team3.riotGamesPerformances.controller;

import ajou.realcoding.team3.riotGamesPerformances.domain.PlayerPerformance;
import ajou.realcoding.team3.riotGamesPerformances.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PerformanceController {
    @Autowired
    GameService gameService;

    @GetMapping("/lol/summoner/get-player-performance/by-name")
    public List<PlayerPerformance> getPlayerPerformance(@RequestParam String summonerName){
        String encryptedID = gameService.getEncryptedIdBySummonerName(summonerName).getId();
        return gameService.getPerformanceByEncryptedSummonerID(encryptedID);
    }

}
