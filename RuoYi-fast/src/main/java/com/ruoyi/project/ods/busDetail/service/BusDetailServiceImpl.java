package com.ruoyi.project.ods.busDetail.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.ods.busDetail.mapper.BusDetailMapper;
import com.ruoyi.project.ods.busDetail.domain.BusDetail;
import com.ruoyi.project.ods.busDetail.service.IBusDetailService;
import com.ruoyi.common.support.Convert;

/**
 * 数据明细 服务层实现
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
@Service
public class BusDetailServiceImpl implements IBusDetailService 
{
	@Autowired
	private BusDetailMapper busDetailMapper;

	/**
     * 查询数据明细信息
     * 
     * @param id 数据明细ID
     * @return 数据明细信息
     */
    @Override
	public BusDetail selectBusDetailById(Integer id)
	{
	    return busDetailMapper.selectBusDetailById(id);
	}
	
	/**
     * 查询数据明细列表
     * 
     * @param busDetail 数据明细信息
     * @return 数据明细集合
     */
	@Override
	public List<BusDetail> selectBusDetailList(BusDetail busDetail)
	{
	    return busDetailMapper.selectBusDetailList(busDetail);
	}
	
    /**
     * 新增数据明细
     * 
     * @param busDetail 数据明细信息
     * @return 结果
     */
	@Override
	public int insertBusDetail(BusDetail busDetail)
	{
	    return busDetailMapper.insertBusDetail(busDetail);
	}
	
	/**
     * 修改数据明细
     * 
     * @param busDetail 数据明细信息
     * @return 结果
     */
	@Override
	public int updateBusDetail(BusDetail busDetail)
	{
	    return busDetailMapper.updateBusDetail(busDetail);
	}

	/**
     * 删除数据明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBusDetailByIds(String ids)
	{
		return busDetailMapper.deleteBusDetailByIds(Convert.toStrArray(ids));
	}
	
}
