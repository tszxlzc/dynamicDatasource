package liuzc.dynamicDatasource.dal.po;

import liuzc.dynamicDatasource.service.dto.BaseDTO;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 共用的PO类，供其他PO类继承
 * @author liuzongchang
 * @version 1.0  2017/5/19 16:19
 */
public class BasePO implements Serializable {
	private static final long serialVersionUID = 4481902705024739770L;

	/**
	 * 对应数据库表主键
	 */
	private Integer id;

	/**
	 * 创建人id，对应用户表主键
	 */
	private Integer creator;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新人id，对应用户表主键
	 */
	private Integer updator;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 软删除标识，0：未删除；1：已删除
	 */
	private Integer deleted;

	public BasePO() {/**重载无参数的构造函数*/}

	public BasePO(BaseDTO baseDTO) {
		if(baseDTO != null){
			BeanUtils.copyProperties(baseDTO,this);
		}
	}

	/**
	 * BasePO转BaseDTO
	 * @author liuzongchang
	 * @version 1.0  2017/5/19 16:25
	 */
	public BaseDTO toBaseDTO(){
		BaseDTO baseDTO = new BaseDTO();
		BeanUtils.copyProperties(this,baseDTO);
		return baseDTO;
	}

	/**
	 * 由子类覆盖，否则从默认位置查找对应的DTO类，没有则抛出异常
	 */
	public Object toDTO() {
		String po = getClass().getSimpleName();
		if (po.endsWith("PO"))
			po = po.substring(0, po.length() - 2);

		String name = getClass().getName();
		String dtoClass = name.substring(0, name.indexOf(".dal.po.")) + ".service.dto." + po + "DTO";
		try {
			Class<?> clz = Class.forName(dtoClass);
			Object baseDTO = clz.newInstance();
			BeanUtils.copyProperties(this, baseDTO);
			return baseDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}

		throw new RuntimeException("PO:" + po + " has no DTO class:" + dtoClass);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		BasePO other = (BasePO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
