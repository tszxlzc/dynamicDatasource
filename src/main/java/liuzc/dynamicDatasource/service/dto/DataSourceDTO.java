package liuzc.dynamicDatasource.service.dto;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 数据源DTO类
 * @author liuzongchang
 * @version 1.0  2017/6/3 16:12
 */
public class DataSourceDTO extends BaseDTO {
	private static final long serialVersionUID = 7490074575945173866L;

	/**数据源名称*/
	private String name;
	/**唯一标识此数据源的key*/
	private String uuidKey;
	/**数据源描述*/
	private String description;
	/**数据源驱动*/
	private String driverClassName;
	/**数据库源类型，取值：mysql,postgresql*/
	private String type;
	/**数据库源地址*/
	private String url;
	/**数据库名称*/
	private String userName;
	/**数据库密码*/
	private String userPwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUuidKey() {
		return uuidKey;
	}

	public void setUuidKey(String uuidKey) {
		this.uuidKey = uuidKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override public String toString() {
		return  ToStringBuilder.reflectionToString(this);
	}
}
