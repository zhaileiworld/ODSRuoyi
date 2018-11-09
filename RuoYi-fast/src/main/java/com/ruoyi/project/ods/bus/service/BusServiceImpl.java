package com.ruoyi.project.ods.bus.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.ods.bus.mapper.BusMapper;
import com.ruoyi.project.ods.bus.domain.Bus;
import com.ruoyi.project.ods.bus.service.IBusService;
import com.ruoyi.common.support.Convert;

/**
 * 业务主 服务层实现
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
@Service
public class BusServiceImpl implements IBusService 
{
	@Autowired
	private BusMapper busMapper;

	/**
     * 查询业务主信息
     * 
     * @param id 业务主ID
     * @return 业务主信息
     */
    @Override
	public Bus selectBusById(Integer id)
	{
	    return busMapper.selectBusById(id);
	}
	
	/**
     * 查询业务主列表
     * 
     * @param bus 业务主信息
     * @return 业务主集合
     */
	@Override
	public List<Bus> selectBusList(Bus bus)
	{
	    return busMapper.selectBusList(bus);
	}
	
    /**
     * 新增业务主
     * 
     * @param bus 业务主信息
     * @return 结果
     */
	@Override
	public int insertBus(Bus bus)
	{
	    return busMapper.insertBus(bus);
	}
	
	/**
     * 修改业务主
     * 
     * @param bus 业务主信息
     * @return 结果
     */
	@Override
	public int updateBus(Bus bus)
	{
	    return busMapper.updateBus(bus);
	}

	/**
     * 删除业务主对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBusByIds(String ids)
	{
		return busMapper.deleteBusByIds(Convert.toStrArray(ids));
	}
	
}
