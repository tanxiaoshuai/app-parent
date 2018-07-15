package cn.wodesh.mapper;


import cn.wodesh.model.FileData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FileDataMapper {

    int deleteByPrimaryKey(String id);

    int insert(FileData record);

    int insertSelective(FileData record);

    FileData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FileData record);

    int updateByPrimaryKey(FileData record);
}