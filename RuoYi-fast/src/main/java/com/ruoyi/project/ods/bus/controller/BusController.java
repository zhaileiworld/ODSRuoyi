package com.ruoyi.project.ods.bus.controller;

import java.util.List;

import com.ruoyi.project.ods.busConfig.service.IBusConfigService;
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
import com.ruoyi.project.ods.bus.domain.Bus;
import com.ruoyi.project.ods.bus.service.IBusService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 业务主 信息操作处理
 *
 * @author ruoyi
 * @date 2018-11-09
 */
@Controller
@RequestMapping("/ods/bus")
public class BusController extends BaseController {
    private String prefix = "ods/bus";

    @Autowired
    private IBusService busService;
    @Autowired
    private IBusConfigService configService;

    @RequiresPermissions("ods:bus:view")
    @GetMapping()
    public String bus() {
        return prefix + "/bus";
    }

    /**
     * 查询业务主列表
     */
    @RequiresPermissions("ods:bus:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Bus bus) {
        startPage();
        List<Bus> list = busService.selectBusList(bus);
        return getDataTable(list);
    }

    /**
     * 新增业务
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存业务主表
     */
    @RequiresPermissions("ods:bus:add")
    @Log(title = "业务主表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Bus bus) {
        return toAjax(busService.insertBus(bus));
    }

    /**
     * 修改业务
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Bus bus = busService.selectBusById(id);
        mmap.put("bus", bus);
        return prefix + "/edit";
    }

    /**
     * 修改保存业务
     */
    @RequiresPermissions("ods:bus:edit")
    @Log(title = "业务主表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Bus bus) {
        return toAjax(busService.updateBus(bus));
    }

    /**
     * 删除业务
     */
    @RequiresPermissions("ods:bus:remove")
    @Log(title = "业务主表", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(busService.deleteBusByIds(ids));
    }


}
