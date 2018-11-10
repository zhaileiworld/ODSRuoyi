package com.ruoyi.project.ods.bus.mapper;

import com.ruoyi.project.ods.bus.domain.Bus;
import com.ruoyi.project.ods.busConfig.domain.BusConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;	

/**
 * 业务主 数据层
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
public interface BusMapper 
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
     * 删除业务主
     * 
     * @param id 业务主ID
     * @return 结果
     */
	public int deleteBusById(Integer id);
	
	/**
     * 批量删除业务主
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBusByIds(String[] ids);

    List<Bus> selectByBusConfig(BusConfig config);

	public int executeSql(@Param(value="sql")String sql);
}