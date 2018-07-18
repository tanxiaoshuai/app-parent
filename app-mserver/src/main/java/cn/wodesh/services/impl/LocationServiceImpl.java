package cn.wodesh.services.impl;

import cn.wodesh.entity.Header;
import cn.wodesh.entity.MongoEntity;
import cn.wodesh.entity.TokenParam;
import cn.wodesh.mongodb.Location;
import cn.wodesh.mongodb.LocationMongoDao;
import cn.wodesh.services.ILocationService;
import cn.wodesh.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by TS on 2018/7/14.
 */
@Service
public class LocationServiceImpl implements ILocationService{

    @Autowired
    private LocationMongoDao locationMongoDao;

    /**
     * 上传位置信息
     * @param location
     * @return
     * @throws Exception
     */
    @Override
    public Object insert(Location location) throws Exception {
        location.setId(KeyUtil.uuid());
        location.setCreateTime(DateUtil.currentTime(DateUtil.YEARTOSS));
        Header header = RequestUtil.getHeader();
        TokenParam tokenParam = TokenUtil.getTokenParam(header.getToken());
        location.setUserId(tokenParam.getUserid());
        locationMongoDao.insert(location);
        return ResultUtil.success();
    }

    /**
     * 那条件查询 时间倒叙排列
     * @param mongoEntity
     * @return
     * @throws Exception
     */
    @Override
    public Object findByList(MongoEntity<Location> mongoEntity) throws Exception {
        return ResultUtil.
                success(locationMongoDao.findByUserIdOrCreateTime(mongoEntity));
    }
}
