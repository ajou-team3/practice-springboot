package ajou.realcoding.team3.riotGamesPerformances.repository;

import ajou.realcoding.team3.riotGamesPerformances.domain.PlayerPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
            if(mongoTemplate.exists(query, PlayerPerformance.class)){
                Update update = new Update();
                update.set("hotStreak", playerPerformance.isHotStreak());
                update.set("MiniSeriesDTO", playerPerformance.getMiniSeries());
                update.set("wins", playerPerformance.getWins());
                update.set("veteran", playerPerformance.isVeteran());
                update.set("losses", playerPerformance.getLosses());
                update.set("rank", playerPerformance.getRank());
                update.set("leagueId", playerPerformance.getLeagueId());
                update.set("inactive", playerPerformance.isInactive());
                update.set("freshBlood", playerPerformance.isFreshBlood());
                update.set("tier", playerPerformance.getTier());
                update.set("leaguePoints", playerPerformance.getLeaguePoints());
                mongoTemplate.updateFirst(query, update, "playerPerformance");
            } else {
                mongoTemplate.insert(playerPerformance);
            }
        }
    }

    public List<PlayerPerformance> findCurrentPerformance(String encryptedSummonerId) {
        Query query = Query.query(Criteria.where("summonerId").is(encryptedSummonerId));
        return mongoTemplate.find(query, PlayerPerformance.class, "playerPerformance");
    }
}