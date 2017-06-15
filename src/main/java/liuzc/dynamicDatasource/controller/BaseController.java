package liuzc.dynamicDatasource.controller;

import liuzc.dynamicDatasource.constant.FrontEndConstant;
import liuzc.dynamicDatasource.constant.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author liuzongchang
 * @version 1.0  2017/5/25 14:00
 */
public class BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * 构建返回结果，包括code， code_message, 及结果信息
	 * @param resultCodeEnum 结果码枚举
	 * @param message 操作结果信息
	 * @author liuzongchang
	 * @version 1.0  2017/6/3 9:25
	 */
	protected Map<String, Object> buildResult(ResultCodeEnum resultCodeEnum, String message){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(FrontEndConstant.CODE, resultCodeEnum.getCode());
		result.put(FrontEndConstant.CODE_MESSAGE, resultCodeEnum.getMessage());
		result.put(FrontEndConstant.MESSAGE, message);
		return result;
	}

}
