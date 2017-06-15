package liuzc.dynamicDatasource.service.iface;


import liuzc.dynamicDatasource.service.dto.DataSourceDTO;
import liuzc.dynamicDatasource.util.dynamicDatasource.DynamicDataSource;

import java.util.List;

/**
 * 数据源服务门面接口
 * @author liuzongchang
 * @version 1.0  2017/6/3 16:38
 */
public interface DatasourceServiceFacade {

	/**
	 * 分页获取数据源，beginRow、rows参数为空时，获取全部
	 * @author liuzongchang
	 * @version 1.0  2017/6/3 16:39
	 */
	List<DataSourceDTO> list(Integer beginRow, Integer rows);

	/**
	 * 查询数据源对应数据库所有表
	 * @author liuzongchang
	 * @version 1.0  2017/6/3 19:59
	 */
	List<String> listTables();

	/**
	 * 查询表的所有字段
	 * @author liuzongchang
	 * @version 1.0  2017/6/3 19:59
	 */
	List<String> listColumns(String table);
}
