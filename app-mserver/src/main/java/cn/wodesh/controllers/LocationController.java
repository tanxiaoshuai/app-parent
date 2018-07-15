package cn.wodesh.controllers;

import cn.wodesh.entity.MongoEntity;
import cn.wodesh.model.Location;
import cn.wodesh.services.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by TS on 2018/7/14.
 */
@RestController
@RequestMapping("/rest")
public class LocationController {

    @Autowired
    private ILocationService locationService;

    @PostMapping("/location/save")
    public Object save(@RequestBody Location location) throws Exception{
        return locationService.insert(location);
    }

    @PostMapping("/location/findByList")
    public Object findByList(@RequestBody MongoEntity<Location> mongoEntity) throws Exception{
        return locationService.findByList(mongoEntity);
    }


}
