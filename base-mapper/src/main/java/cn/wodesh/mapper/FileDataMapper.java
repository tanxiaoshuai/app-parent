package cn.wodesh.mapper;


import cn.wodesh.entity.Page;
import cn.wodesh.model.FileData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface FileDataMapper {

    int deleteByPrimaryKey(String id);

    int insert(FileData record);

    int insertSelective(FileData record);

    FileData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FileData record);

    int updateByPrimaryKey(FileData record);

    List<FileData> selectList(Page<FileData> fileDataPage);
}