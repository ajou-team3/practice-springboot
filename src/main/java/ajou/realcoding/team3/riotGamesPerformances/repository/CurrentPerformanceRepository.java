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

    public void manageCurrentPerformance(PlayerPerformance playerPerformance){
        Query query = Query.query(Criteria.where("summonerId").is(playerPerformance.getSummonerId()));

        mongoTemplate.insert(playerPerformance);

    }

    public PlayerPerformance findCurrentPerformance(String encryptedSummonerId) {
        Query query = Query.query(Criteria.where("summonerId").is(encryptedSummonerId));
        return mongoTemplate.findOne(query, PlayerPerformance.class);
    }
}
