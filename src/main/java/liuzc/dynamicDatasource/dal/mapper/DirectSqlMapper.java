package liuzc.dynamicDatasource.dal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 直接执行相关sql的Mapper
 *
 */
public interface DirectSqlMapper {

    List<Map<String, Object>> getListBySql(@Param("sql") String sql);

    /**
     * 直接按sql查询，返回一个对象信息
     * @param sql 要执行的sql语句
     * @return Object
     */
    Object getObjectBySql(@Param("sql") String sql);
}
