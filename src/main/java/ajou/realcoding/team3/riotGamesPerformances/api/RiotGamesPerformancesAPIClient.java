package ajou.realcoding.team3.riotGamesPerformances.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotGamesPerformancesAPIClient {

    private final String apikey = "RGAPI-ec1bf40e-0377-4c43-a4c4-92cc97032e15";
    private final String summonorV4Url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={apikey}";
    private final String leagueV4Url = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={apikey}";


    @Autowired
    RestTemplate resttemplate;

 /*
    public PlayerEncryptedID requestEncryptedID(String summonerName)
    public PlayerPerformance requestPerformance(String encryptedSummonerId)
 */

}
