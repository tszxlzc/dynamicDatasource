package liuzc.dynamicDatasource.controller;

import la.kaike.platform.common.lang.JsonUtils;
import la.kaike.platform.common.lang.StringUtils;
import liuzc.dynamicDatasource.constant.ResultCodeEnum;
import liuzc.dynamicDatasource.service.iface.DatasourceServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 数据源controller
 * @author liuzongchang
 * @version 1.0  2017/6/3 17:21
 */
@Controller
@RequestMapping("datasource")
public class DataSourceController extends BaseController{
    @Autowired
	private DatasourceServiceFacade datasourceServiceFacade;


	/**
	 * 获取数据源所有的数据库表
	 * @author liuzongchang
	 * @version 1.0  2017/6/3 20:02
	 */
	@RequestMapping(value = "list_table", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
	@ResponseBody
	public String listTables(){
		List<String> tableList = datasourceServiceFacade.listTables();
		Map<String, Object> result = buildResult(ResultCodeEnum.SUCCESS, "获取数据源表信息成功。");
		result.put("tableList", tableList);
		return JsonUtils.bean2Json(result);
	}

	@RequestMapping(value = "list_column", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
	@ResponseBody
	public String listColumns(String table){
		if(StringUtils.isEmpty(table) || table.contains(";")){//判断是否有分号，防止sql注入
			return buildResult(ResultCodeEnum.PARAM_CHECK, "表名称不能为空或不合法").toString();
		}
		List<String> columnList = datasourceServiceFacade.listColumns(table);
		Map<String, Object> result = buildResult(ResultCodeEnum.SUCCESS, "获取数据库表（列信息）成功。");
		result.put("columnList", columnList);
		return result.toString();
	}
}
