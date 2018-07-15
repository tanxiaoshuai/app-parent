package cn.wodesh.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TS on 2018/7/14.
 */
public class MongoBaseDao<T>{

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 添加实例对象
     * @param t
     */
    public void insert(T t){
        mongoTemplate.insert(t);
    }

    /**
     * 根据对象查询集合
     * @param t
     * @return
     */
    public List<T> findAll(Class<T> t){
        return mongoTemplate.findAll(t);
    }




}
