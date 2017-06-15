package liuzc.dynamicDatasource.dal.po;

import liuzc.dynamicDatasource.service.dto.DataSourceDTO;
import org.springframework.beans.BeanUtils;

/**
 * 数据源配置信息
 *
 */
public class DataSourcePO extends BasePO {

  private static final long serialVersionUID = 4797970474866873349L;
  /**
   * 数据源名称
   */
  private String name;

  /**
   * 此数据源的唯一标识
   */
  private String uuidKey;

  /**
   * 数据源描述
   */
  private String description;

  /**
   * 数据源类型，取值为：mysql,postgresql
   */
  private String type;

  /**
   * 数据源连接字符串
   */
  private String url;

  /**
   * 数据源驱动
   */
  private String driverClassName;

  /**
   * 用户名
   */
  private String userName;

  /**
   * 密码，druid加密
   */
  private String userPwd;

  public DataSourcePO() {
  }

  public DataSourcePO(DataSourceDTO dataSourceDTO) {
    if(dataSourceDTO != null){
      BeanUtils.copyProperties(dataSourceDTO, this);
    }
  }

  public DataSourcePO(String uuidKey, String driverClassName, String url, String userName, String userPwd) {
    this.uuidKey = uuidKey;
    this.driverClassName = driverClassName;
    this.url = url;
    this.userName = userName;
    this.userPwd = userPwd;
  }

  public DataSourcePO(String uuidKey, String name, String description, String type, String driverClassName, String url, String userName, String userPwd) {
    this.uuidKey = uuidKey;
    this.name = name;
    this.description = description;
    this.type = type;
    this.driverClassName = driverClassName;
    this.url = url;
    this.userName = userName;
    this.userPwd = userPwd;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public String getDriverClassName() {
    return driverClassName;
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }

  public String getUuidKey() {
    return uuidKey;
  }

  public void setUuidKey(String uuidKey) {
    this.uuidKey = uuidKey;
  }
}
