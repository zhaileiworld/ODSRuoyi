package com.ruoyi.project.ods.plan.mapper;

import com.ruoyi.project.ods.plan.domain.Plan;
import java.util.List;	

/**
 * 计划执行记录 数据层
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
public interface PlanMapper 
{
	/**
     * 查询计划执行记录信息
     * 
     * @param id 计划执行记录ID
     * @return 计划执行记录信息
     */
	public Plan selectPlanById(Integer id);
	
	/**
     * 查询计划执行记录列表
     * 
     * @param plan 计划执行记录信息
     * @return 计划执行记录集合
     */
	public List<Plan> selectPlanList(Plan plan);
	
	/**
     * 新增计划执行记录
     * 
     * @param plan 计划执行记录信息
     * @return 结果
     */
	public int insertPlan(Plan plan);
	
	/**
     * 修改计划执行记录
     * 
     * @param plan 计划执行记录信息
     * @return 结果
     */
	public int updatePlan(Plan plan);
	
	/**
     * 删除计划执行记录
     * 
     * @param id 计划执行记录ID
     * @return 结果
     */
	public int deletePlanById(Integer id);
	
	/**
     * 批量删除计划执行记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePlanByIds(String[] ids);
	
}