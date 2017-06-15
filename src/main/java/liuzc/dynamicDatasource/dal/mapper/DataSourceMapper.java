package liuzc.dynamicDatasource.dal.mapper;

import liuzc.dynamicDatasource.service.dto.DataSourceDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataSourceMapper {

    /**
     * 获取数据库配置的数据源列表
     * @param pageIndex 分页参数，起始位置
     * @param pageSize 分页参数，每页大小
     * @return 数据源配置信息列表
     */
    List<DataSourceDTO> getDataSourceList(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 获取数据源总记录数
     * @return 数据源总记录数
     */
    Integer getDataSourceCount();
}
