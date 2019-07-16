package ajou.realcoding.team3.riotGamesPerformances.repository;

import ajou.realcoding.team3.riotGamesPerformances.domain.PlayerPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrentPerformanceRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public void manageCurrentPerformance(PlayerPerformance[] playerPerformances) {
        for (PlayerPerformance playerPerformance : playerPerformances) {
            Query query = Query.query(Criteria.where("summonerId").is(playerPerformance.getSummonerId()));
            query.addCriteria(Criteria.where("queueType").is(playerPerformance.getQueueType()));
            mongoTemplate.insert(playerPerformance);
        }
    }

    public List<PlayerPerformance> findCurrentPerformance(String encryptedSummonerId) {
        Query query = Query.query(Criteria.where("summonerId").is(encryptedSummonerId));
        return mongoTemplate.find(query, PlayerPerformance.class, "playerPerformance");
    }
}