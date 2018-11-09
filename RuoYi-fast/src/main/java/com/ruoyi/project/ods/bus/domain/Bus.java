package com.ruoyi.project.ods.bus.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 业务主表 tf_bus
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
public class Bus extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 表名 */
	private String tablename;
	/** 表描述 */
	private String tabledesc;
	/** 文件名 */
	private String filename;
	/** 添加时间 */
	private String addtime;
	/** 更新时间 */
	private String updatetime;
	/** 0不更新1更新 */
	private Integer isupdate;
	/** 业务配置id */
	private Integer configId;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setTablename(String tablename) 
	{
		this.tablename = tablename;
	}

	public String getTablename() 
	{
		return tablename;
	}
	public void setTabledesc(String tabledesc) 
	{
		this.tabledesc = tabledesc;
	}

	public String getTabledesc() 
	{
		return tabledesc;
	}
	public void setFilename(String filename) 
	{
		this.filename = filename;
	}

	public String getFilename() 
	{
		return filename;
	}
	public void setAddtime(String addtime) 
	{
		this.addtime = addtime;
	}

	public String getAddtime() 
	{
		return addtime;
	}
	public void setUpdatetime(String updatetime) 
	{
		this.updatetime = updatetime;
	}

	public String getUpdatetime() 
	{
		return updatetime;
	}
	public void setIsupdate(Integer isupdate) 
	{
		this.isupdate = isupdate;
	}

	public Integer getIsupdate() 
	{
		return isupdate;
	}
	public void setConfigId(Integer configId) 
	{
		this.configId = configId;
	}

	public Integer getConfigId() 
	{
		return configId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tablename", getTablename())
            .append("tabledesc", getTabledesc())
            .append("filename", getFilename())
            .append("addtime", getAddtime())
            .append("updatetime", getUpdatetime())
            .append("isupdate", getIsupdate())
            .append("configId", getConfigId())
            .toString();
    }
}
