package com.ruoyi.project.ods.busDetail.service;

import com.ruoyi.project.ods.busDetail.domain.BusDetail;
import java.util.List;

/**
 * 数据明细 服务层
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
public interface IBusDetailService 
{
	/**
     * 查询数据明细信息
     * 
     * @param id 数据明细ID
     * @return 数据明细信息
     */
	public BusDetail selectBusDetailById(Integer id);
	
	/**
     * 查询数据明细列表
     * 
     * @param busDetail 数据明细信息
     * @return 数据明细集合
     */
	public List<BusDetail> selectBusDetailList(BusDetail busDetail);
	
	/**
     * 新增数据明细
     * 
     * @param busDetail 数据明细信息
     * @return 结果
     */
	public int insertBusDetail(BusDetail busDetail);
	
	/**
     * 修改数据明细
     * 
     * @param busDetail 数据明细信息
     * @return 结果
     */
	public int updateBusDetail(BusDetail busDetail);
		
	/**
     * 删除数据明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBusDetailByIds(String ids);


	/**
	 * 根据主表id查询明细 列表
	 * @param tableid  主表id
	 * @return
	 */
	public List<BusDetail> selectBusDetailByTableId(Integer tableid);

}
