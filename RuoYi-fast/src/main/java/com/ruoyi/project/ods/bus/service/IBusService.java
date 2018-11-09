package com.ruoyi.project.ods.bus.service;

import com.ruoyi.project.ods.bus.domain.Bus;
import com.ruoyi.project.ods.busConfig.domain.BusConfig;

import java.util.List;

/**
 * 业务主 服务层
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
public interface IBusService 
{
	/**
     * 查询业务主信息
     * 
     * @param id 业务主ID
     * @return 业务主信息
     */
	public Bus selectBusById(Integer id);
	
	/**
     * 查询业务主列表
     * 
     * @param bus 业务主信息
     * @return 业务主集合
     */
	public List<Bus> selectBusList(Bus bus);
	
	/**
     * 新增业务主
     * 
     * @param bus 业务主信息
     * @return 结果
     */
	public int insertBus(Bus bus);
	
	/**
     * 修改业务主
     * 
     * @param bus 业务主信息
     * @return 结果
     */
	public int updateBus(Bus bus);
		
	/**
     * 删除业务主信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBusByIds(String ids);

	/**
	 * 根据业务配置表的条件查询对应业务主表的列表
	 * @param BusConfig
	 * @return List<>
	 * */
	public List<Bus> selectByBusConfig(BusConfig config);
}
