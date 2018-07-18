package cn.wodesh.mongodb;

import cn.wodesh.entity.MongoEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by TS on 2018/7/15.
 */
@Repository
public class LocationMongoDao extends MongoBaseDao<Location>{

    /**
     * 根据用户id 按时间范围查询
     * @param mongoEntity
     * @return
     */
    public List<Location> findByUserIdOrCreateTime(MongoEntity<Location> mongoEntity){
        Criteria criteria = Criteria.where("userId").is(mongoEntity.getData().getUserId())
                .where("createTime").gte(mongoEntity.getStartTime()).lte(mongoEntity.getEndTime());
        Query query = new Query(criteria)
                .with(new Sort(Sort.Direction.ASC,"createTime"));
        List<Location> list = mongoTemplate.find(query , Location.class);
        return list;
    }
}
