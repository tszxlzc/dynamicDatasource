package liuzc.dynamicDatasource.constant;

/**
 * 结果枚举类
 * @author liuzongchang
 * @version 1.0  2017/2/28 10:30
 */
public enum ResultCodeEnum {
	SUCCESS("0","成功。"),
	PARAM_CHECK("40001","参数校验错误"),
	BIZ_CHECK("40002","业务校验错误"),
	SYSTEM_ERROR("40003","系统错误，请联系系统owner！");

	private  String code;
	private  String message;

	ResultCodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
