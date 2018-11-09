package com.ruoyi.project.ods.busConfig.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 业务配置表 tf_bus_config
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
public class BusConfig extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 业务描述 */
	private String description;
	/** 启用状态 0 未启用 1 已启用 */
	private Integer status;
	/** 创建日期 */
	private String beginDate;
	/** 上一次执行任务日期 */
	private String beforeDate;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setBeginDate(String beginDate) 
	{
		this.beginDate = beginDate;
	}

	public String getBeginDate() 
	{
		return beginDate;
	}
	public void setBeforeDate(String beforeDate) 
	{
		this.beforeDate = beforeDate;
	}

	public String getBeforeDate() 
	{
		return beforeDate;
	}

	public BusConfig() {
	}

	public BusConfig(Integer status) {
		this.status = status;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("beginDate", getBeginDate())
            .append("beforeDate", getBeforeDate())
            .toString();
    }
}
