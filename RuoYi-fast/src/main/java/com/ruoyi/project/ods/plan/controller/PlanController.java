package com.ruoyi.project.ods.plan.controller;

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
import com.ruoyi.project.ods.plan.domain.Plan;
import com.ruoyi.project.ods.plan.service.IPlanService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 计划执行记录 信息操作处理
 *
 * @author ruoyi
 * @date 2018-11-09
 */
@Controller
@RequestMapping("/ods/plan")
public class PlanController extends BaseController {
    private String prefix = "ods/plan";

    @Autowired
    private IPlanService planService;

    @RequiresPermissions("ods:plan:view")
    @GetMapping()
    public String plan() {
        return prefix + "/plan";
    }

    /**
     * 查询计划执行记录列表
     */
    @RequiresPermissions("ods:plan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Plan plan) {
        startPage();
        List<Plan> list = planService.selectPlanList(plan);
        return getDataTable(list);
    }

    /**
     * 新增计划执行记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存计划执行记录
     */
    @RequiresPermissions("ods:plan:add")
    @Log(title = "计划执行记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Plan plan) {
        return toAjax(planService.insertPlan(plan));
    }

    /**
     * 修改计划执行记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Plan plan = planService.selectPlanById(id);
        mmap.put("plan", plan);
        return prefix + "/edit";
    }

    /**
     * 修改保存计划执行记录
     */
    @RequiresPermissions("ods:plan:edit")
    @Log(title = "计划执行记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Plan plan) {
        return toAjax(planService.updatePlan(plan));
    }

    /**
     * 删除计划执行记录
     */
    @RequiresPermissions("ods:plan:remove")
    @Log(title = "计划执行记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(planService.deletePlanByIds(ids));
    }

}
