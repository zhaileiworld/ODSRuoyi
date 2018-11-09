package com.ruoyi.project.ods.busDetail.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 数据明细表 tf_bus_detail
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
public class BusDetail extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer id;
	/** 业务主表ID */
	private Integer tableid;
	/** 字段位置 */
	private Integer fieldlocation;
	/** 字段名称 */
	private String fieldname;
	/** 字段详述 */
	private String fielddesc;
	/** 字段类型 */
	private String fieldtype;
	/** 是否主键 0 否 1 是 */
	private Integer iskey;
	/** 长度 */
	private Integer length;
	/** 添加时间 */
	private String addtime;
	/** 修改时间 */
	private String updatetime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setTableid(Integer tableid) 
	{
		this.tableid = tableid;
	}

	public Integer getTableid() 
	{
		return tableid;
	}
	public void setFieldlocation(Integer fieldlocation) 
	{
		this.fieldlocation = fieldlocation;
	}

	public Integer getFieldlocation() 
	{
		return fieldlocation;
	}
	public void setFieldname(String fieldname) 
	{
		this.fieldname = fieldname;
	}

	public String getFieldname() 
	{
		return fieldname;
	}
	public void setFielddesc(String fielddesc) 
	{
		this.fielddesc = fielddesc;
	}

	public String getFielddesc() 
	{
		return fielddesc;
	}
	public void setFieldtype(String fieldtype)
	{
		this.fieldtype = fieldtype;
	}

	public String getFieldtype()
	{
		return fieldtype;
	}
	public void setIskey(Integer iskey) 
	{
		this.iskey = iskey;
	}

	public Integer getIskey() 
	{
		return iskey;
	}
	public void setLength(Integer length) 
	{
		this.length = length;
	}

	public Integer getLength() 
	{
		return length;
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

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tableid", getTableid())
            .append("fieldlocation", getFieldlocation())
            .append("fieldname", getFieldname())
            .append("fielddesc", getFielddesc())
            .append("type", getFieldtype())
            .append("iskey", getIskey())
            .append("length", getLength())
            .append("addtime", getAddtime())
            .append("updatetime", getUpdatetime())
            .toString();
    }
}
