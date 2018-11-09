package com.ruoyi.project.ods.busConfig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.ods.busConfig.mapper.BusConfigMapper;
import com.ruoyi.project.ods.busConfig.domain.BusConfig;
import com.ruoyi.project.ods.busConfig.service.IBusConfigService;
import com.ruoyi.common.support.Convert;

/**
 * 业务配置 服务层实现
 *
 * @author ruoyi
 * @date 2018-11-09
 */
@Service
public class BusConfigServiceImpl implements IBusConfigService {
    @Autowired
    private BusConfigMapper busConfigMapper;

    /**
     * 查询业务配置信息
     *
     * @param id 业务配置ID
     * @return 业务配置信息
     */
    @Override
    public BusConfig selectBusConfigById(Integer id) {
        return busConfigMapper.selectBusConfigById(id);
    }

    /**
     * 查询业务配置列表
     *
     * @param busConfig 业务配置信息
     * @return 业务配置集合
     */
    @Override
    public List<BusConfig> selectBusConfigList(BusConfig busConfig) {
        return busConfigMapper.selectBusConfigList(busConfig);
    }

    /**
     * 新增业务配置
     *
     * @param busConfig 业务配置信息
     * @return 结果
     */
    @Override
    public int insertBusConfig(BusConfig busConfig) {
        return busConfigMapper.insertBusConfig(busConfig);
    }

    /**
     * 修改业务配置
     *
     * @param busConfig 业务配置信息
     * @return 结果
     */
    @Override
    public int updateBusConfig(BusConfig busConfig) {
        return busConfigMapper.updateBusConfig(busConfig);
    }

    /**
     * 删除业务配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusConfigByIds(String ids) {
        return busConfigMapper.deleteBusConfigByIds(Convert.toStrArray(ids));
    }

}
