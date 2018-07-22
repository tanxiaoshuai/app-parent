package cn.wodesh;

import cn.wodesh.mapper.FileDataMapper;
import cn.wodesh.model.FileData;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UploadMserverApplicationTests {

	@Autowired
	private FileDataMapper fileDataMapper;


	@Test
	public void contextLoads() {
//		PageHelper.startPage(2, 1);
//		List<FileData> list = fileDataMapper.selectList();
//		PageInfo<FileData> appsPageInfo = new PageInfo<>(list);
//		System.out.println(JSONObject.toJSON(appsPageInfo));
	}

}
