package ajou.realcoding.team3.riotGamesPerformances.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConfig {
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
