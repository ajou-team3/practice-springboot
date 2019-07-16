package ajou.realcoding.team3.riotGamesPerformances.api;

import ajou.realcoding.team3.riotGamesPerformances.domain.PlayerEncryptedID;
import ajou.realcoding.team3.riotGamesPerformances.domain.PlayerPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotGamesPerformancesAPIClient {

    private final String apikey = "RGAPI-81174976-ddc1-486f-8b4a-5a6ff36ed103";
    private final String baseUrl = "https://kr.api.riotgames.com";
    private final String authUrl = "?api_key={apikey}";
    private final String summonerV4Url = "/lol/summoner/v4/summoners/by-name/{summonerName}";
    private final String leagueV4Url = "/lol/league/v4/entries/by-summoner/{encryptedSummonerId}";


    @Autowired
    RestTemplate restTemplate;

    public PlayerEncryptedID requestEncryptedID(String summonerName) {
        return restTemplate.exchange(baseUrl+summonerV4Url+authUrl, HttpMethod.GET, null, PlayerEncryptedID.class, summonerName, apikey).getBody();
    }

    public PlayerPerformance[] requestPerformance(String encryptedSummonerId) {
        PlayerPerformance[] performances = restTemplate.exchange(baseUrl+leagueV4Url+authUrl, HttpMethod.GET, null, PlayerPerformance[].class, encryptedSummonerId, apikey).getBody();
        return performances;
    }

}
