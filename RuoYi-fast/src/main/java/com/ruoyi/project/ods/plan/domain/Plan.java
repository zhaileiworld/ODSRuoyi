package com.ruoyi.project.ods.plan.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 计划执行记录表 tf_plan
 *
 * @author ruoyi
 * @date 2018-11-09
 */
public class Plan extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;
    /**
     * 业务主表ID
     */
    private Integer busid;
    /**
     * 表名称
     */
    private String tableName;
    /**
     * 执行状态 1.成功 2.失败
     */
    private Integer dealStatus;
    /**
     * 执行时间
     */
    private String dealTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setBusid(Integer busid) {
        this.busid = busid;
    }

    public Integer getBusid() {
        return busid;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealTime(String dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealTime() {
        return dealTime;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("busid", getBusid())
                .append("tableName", getTableName())
                .append("dealStatus", getDealStatus())
                .append("dealTime", getDealTime())
                .toString();
    }
}
