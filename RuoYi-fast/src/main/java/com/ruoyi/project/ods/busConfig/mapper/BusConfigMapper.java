package com.ruoyi.project.ods.busConfig.mapper;

import com.ruoyi.project.ods.busConfig.domain.BusConfig;
import java.util.List;	

/**
 * 业务配置 数据层
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
public interface BusConfigMapper 
{
	/**
     * 查询业务配置信息
     * 
     * @param id 业务配置ID
     * @return 业务配置信息
     */
	public BusConfig selectBusConfigById(Integer id);
	
	/**
     * 查询业务配置列表
     * 
     * @param busConfig 业务配置信息
     * @return 业务配置集合
     */
	public List<BusConfig> selectBusConfigList(BusConfig busConfig);
	
	/**
     * 新增业务配置
     * 
     * @param busConfig 业务配置信息
     * @return 结果
     */
	public int insertBusConfig(BusConfig busConfig);
	
	/**
     * 修改业务配置
     * 
     * @param busConfig 业务配置信息
     * @return 结果
     */
	public int updateBusConfig(BusConfig busConfig);
	
	/**
     * 删除业务配置
     * 
     * @param id 业务配置ID
     * @return 结果
     */
	public int deleteBusConfigById(Integer id);
	
	/**
     * 批量删除业务配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBusConfigByIds(String[] ids);
	
}