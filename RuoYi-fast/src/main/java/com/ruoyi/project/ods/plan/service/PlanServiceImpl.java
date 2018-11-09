package com.ruoyi.project.ods.plan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.ods.plan.mapper.PlanMapper;
import com.ruoyi.project.ods.plan.domain.Plan;
import com.ruoyi.project.ods.plan.service.IPlanService;
import com.ruoyi.common.support.Convert;

/**
 * 计划执行记录 服务层实现
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
@Service
public class PlanServiceImpl implements IPlanService 
{
	@Autowired
	private PlanMapper planMapper;

	/**
     * 查询计划执行记录信息
     * 
     * @param id 计划执行记录ID
     * @return 计划执行记录信息
     */
    @Override
	public Plan selectPlanById(Integer id)
	{
	    return planMapper.selectPlanById(id);
	}
	
	/**
     * 查询计划执行记录列表
     * 
     * @param plan 计划执行记录信息
     * @return 计划执行记录集合
     */
	@Override
	public List<Plan> selectPlanList(Plan plan)
	{
	    return planMapper.selectPlanList(plan);
	}
	
    /**
     * 新增计划执行记录
     * 
     * @param plan 计划执行记录信息
     * @return 结果
     */
	@Override
	public int insertPlan(Plan plan)
	{
	    return planMapper.insertPlan(plan);
	}
	
	/**
     * 修改计划执行记录
     * 
     * @param plan 计划执行记录信息
     * @return 结果
     */
	@Override
	public int updatePlan(Plan plan)
	{
	    return planMapper.updatePlan(plan);
	}

	/**
     * 删除计划执行记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePlanByIds(String ids)
	{
		return planMapper.deletePlanByIds(Convert.toStrArray(ids));
	}
	
}
