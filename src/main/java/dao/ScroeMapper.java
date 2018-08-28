package dao;

import java.util.List;
import model.Scroe;
import model.ScroeExample;
import org.apache.ibatis.annotations.Param;

public interface ScroeMapper {
    int countByExample(ScroeExample example);

    int deleteByExample(ScroeExample example);

    int insert(Scroe record);

    int insertSelective(Scroe record);

    List<Scroe> selectByExample(ScroeExample example);

    int updateByExampleSelective(@Param("record") Scroe record, @Param("example") ScroeExample example);

    int updateByExample(@Param("record") Scroe record, @Param("example") ScroeExample example);
}