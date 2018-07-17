package cn.wodesh.util;

import cn.wodesh.model.FileData;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * Created by TS on 2018/7/17.
 */
public class FilterParam {

    public static Map fileDtaeFilter(FileData fileData){
        Map map = (Map) JSONObject.toJSON(fileData);
        map.remove("keyFormPath");
        map.remove("storageLocation");
        return map;
    }
}
