package liuzc.dynamicDatasource.service.iface.impl;

import liuzc.dynamicDatasource.dal.mapper.DataSourceMapper;
import liuzc.dynamicDatasource.dal.mapper.DirectSqlMapper;
import liuzc.dynamicDatasource.service.dto.DataSourceDTO;
import liuzc.dynamicDatasource.service.iface.DatasourceServiceFacade;
import liuzc.dynamicDatasource.util.dynamicDatasource.DbContextHolder;
import liuzc.dynamicDatasource.util.dynamicDatasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据源服务门面实现类
 * @author liuzongchang
 * @version 1.0  2017/6/3 17:25
 */
@Service
public class DatasouceServcieFacadeImpl implements DatasourceServiceFacade {
	@Autowired
	private DataSourceMapper dataSourceMapper;
	@Autowired
	private DirectSqlMapper directSqlMapper;
	@Autowired
	private DynamicDataSource dynamicDatasource;
	public List<DataSourceDTO> list(Integer beginRow, Integer rows) {
		return dataSourceMapper.getDataSourceList(beginRow, rows);
	}

	public List<String> listTables() {
//		DbContextHolder.setDbType("managerDataSource");
		DbContextHolder.setDbType("rptDataSource");
		Connection connection = null;
		String database = "";
		try {
			connection = dynamicDatasource.getConnection();
			database = connection.getCatalog();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			assert connection != null;
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		String sql = "SHOW TABLES";
		List<Map<String, Object>> tables = directSqlMapper.getListBySql(sql);
		List<String> tableList = new ArrayList<String>();
		if(tables != null){
			for(Map<String, Object> map :tables){
				tableList.add(map.get("Tables_in_" + database).toString()); //bi_rpt为默认的报表库
//				tableList.add(map.get("Tables_in_bi_manager").toString()); //bi_rpt为默认的报表库
			}
		}

		return tableList;
	}

	public List<String> listColumns(String table) {
		List<Map<String, Object>> columns = directSqlMapper.getListBySql("Desc " + table);
		List<String> columnList = new ArrayList<String>();
		if(columns != null){
			for (Map<String, Object> map : columns){
				columnList.add(map.get("Field").toString());
			}
		}

		return  columnList;
	}
}
