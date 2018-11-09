package com.ruoyi.project.ods.busDetail.controller;

import java.util.List;

import com.ruoyi.project.ods.bus.domain.Bus;
import com.ruoyi.project.ods.bus.service.IBusService;
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
import com.ruoyi.project.ods.busDetail.domain.BusDetail;
import com.ruoyi.project.ods.busDetail.service.IBusDetailService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 数据明细 信息操作处理
 *
 * @author ruoyi
 * @date 2018-11-09
 */
@Controller
@RequestMapping("/ods/busDetail")
public class BusDetailController extends BaseController {
    private String prefix = "ods/busDetail";

    @Autowired
    private IBusDetailService busDetailService;
    @Autowired
    private IBusService busService;


    @RequiresPermissions("ods:busDetail:view")
    @GetMapping()
    public String busDetail() {
        return prefix + "/busDetail";
    }

    /**
     * 查询数据明细列表
     */
    @RequiresPermissions("ods:busDetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusDetail busDetail) {
        startPage();
        List<BusDetail> list = busDetailService.selectBusDetailList(busDetail);
        return getDataTable(list);
    }

    /**
     * 新增数据明细
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap) {
        modelMap.put("bus",busService.selectBusList(new Bus()));
        return prefix + "/add";
    }

    /**
     * 新增保存数据明细
     */
    @RequiresPermissions("ods:busDetail:add")
    @Log(title = "业务数据明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusDetail busDetail) {
        return toAjax(busDetailService.insertBusDetail(busDetail));
    }

    /**
     * 修改数据明细
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        BusDetail busDetail = busDetailService.selectBusDetailById(id);
        mmap.put("busDetail", busDetail);
        mmap.put("bus",busService.selectBusList(new Bus()));
        return prefix + "/edit";
    }

    /**
     * 修改保存数据明细
     */
    @RequiresPermissions("ods:busDetail:edit")
    @Log(title = "业务数据明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusDetail busDetail) {
        return toAjax(busDetailService.updateBusDetail(busDetail));
    }

    /**
     * 删除数据明细
     */
    @RequiresPermissions("ods:busDetail:remove")
    @Log(title = "业务数据明细", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(busDetailService.deleteBusDetailByIds(ids));
    }

}
