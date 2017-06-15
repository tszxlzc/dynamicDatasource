package liuzc.dynamicDatasource.service.dto;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础DTO类，供其他DTO类继承
 * @author liuzongchang
 * @version 1.0  2017/5/19 16:00
 */
public class BaseDTO implements Serializable {

	private static final long serialVersionUID = 7082114727186646349L;

	/**
	 * 对应数据库表主键
	 */
	private Integer id;

	/**
	 * 创建人id，对应用户表主键
	 */
	private Integer creator;

	/**
	 * 创建人名称
	 */
	private String creatorName;

	/**
	 * 更新时间
	 */
	private Date createTime;

	/**
	 * 更新人id，对应用户表主键
	 */
	private Integer updator;

	/**
	 * 更新人名称
	 */
	private String updatorName;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 软删除标识，0：未删除；1：已删除
	 */
	private Integer deleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdator() {
		return updator;
	}

	public void setUpdator(Integer updator) {
		this.updator = updator;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getUpdatorName() {
		return updatorName;
	}

	public void setUpdatorName(String updatorName) {
		this.updatorName = updatorName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
