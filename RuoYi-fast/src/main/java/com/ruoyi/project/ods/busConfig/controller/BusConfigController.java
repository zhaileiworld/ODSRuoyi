package com.ruoyi.project.ods.busConfig.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.ods.busConfig.domain.BusConfig;
import com.ruoyi.project.ods.busConfig.service.IBusConfigService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 业务配置 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-11-09
 */
@Controller
@RequestMapping("/ods/busConfig")
public class BusConfigController extends BaseController
{
    private String prefix = "ods/busConfig";
	
	@Autowired
	private IBusConfigService busConfigService;
	
	@RequiresPermissions("ods:busConfig:view")
	@GetMapping()
	public String busConfig()
	{
	    return prefix + "/busConfig";
	}
	
	/**
	 * 查询业务配置列表
	 */
	@RequiresPermissions("ods:busConfig:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BusConfig busConfig)
	{
		startPage();
        List<BusConfig> list = busConfigService.selectBusConfigList(busConfig);
		return getDataTable(list);
	}
	
	/**
	 * 新增业务配置
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存业务配置
	 */
	@RequiresPermissions("ods:busConfig:add")
	@Log(title = "业务配置", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BusConfig busConfig)
	{		
		return toAjax(busConfigService.insertBusConfig(busConfig));
	}

	/**
	 * 修改业务配置
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		BusConfig busConfig = busConfigService.selectBusConfigById(id);
		mmap.put("busConfig", busConfig);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存业务配置
	 */
	@RequiresPermissions("ods:busConfig:edit")
	@Log(title = "业务配置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BusConfig busConfig)
	{		
		return toAjax(busConfigService.updateBusConfig(busConfig));
	}
	
	/**
	 * 删除业务配置
	 */
	@RequiresPermissions("ods:busConfig:remove")
	@Log(title = "业务配置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(busConfigService.deleteBusConfigByIds(ids));
	}
	
}
