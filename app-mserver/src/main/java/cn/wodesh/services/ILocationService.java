package cn.wodesh.services;

import cn.wodesh.entity.MongoEntity;
import cn.wodesh.mongodb.Location;

/**
 * Created by TS on 2018/7/14.
 */
public interface ILocationService {

    /**
     * 上传位置信息
     * @param location
     * @return
     * @throws Exception
     */
    Object insert(Location location) throws Exception;

    /**
     * 那条件查询 时间倒叙排列
     * @param mongoEntity
     * @return
     * @throws Exception
     */
    Object findByList(MongoEntity<Location> mongoEntity) throws Exception;
}
