package dao;

import java.util.List;
import model.DbConfig;
import model.DbConfigExample;
import org.apache.ibatis.annotations.Param;

public interface DbConfigMapper {
    int countByExample(DbConfigExample example);

    int deleteByExample(DbConfigExample example);

    int insert(DbConfig record);

    int insertSelective(DbConfig record);

    List<DbConfig> selectByExample(DbConfigExample example);

    int updateByExampleSelective(@Param("record") DbConfig record, @Param("example") DbConfigExample example);

    int updateByExample(@Param("record") DbConfig record, @Param("example") DbConfigExample example);
}