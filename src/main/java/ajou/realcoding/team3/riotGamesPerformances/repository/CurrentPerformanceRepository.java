package ajou.realcoding.team3.riotGamesPerformances.repository;

import ajou.realcoding.team3.riotGamesPerformances.domain.PlayerPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentPerformanceRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public void manageCurrentPerformance(PlayerPerformance[] playerPerformances) {
        for (int i = 0; i < playerPerformances.length; i++) {
            Query query = Query.query(Criteria.where("summonerId").is(playerPerformances[i].getSummonerId()));
            mongoTemplate.insert(playerPerformances[i]);
        }

    }

    public PlayerPerformance[] findCurrentPerformance(String encryptedSummonerId, PlayerPerformance[] playerPerformances) {
        int queueTypeCount = 0;
        for(int i=0; i<playerPerformances.length; i++) {
            Query query = Query.query(Criteria.where("summonerId").is(playerPerformances[i].getSummonerId()));
            playerPerformances[queueTypeCount] = mongoTemplate.findOne(query, PlayerPerformance.class);
        }
        return playerPerformances;
    }
}
