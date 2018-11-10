package com.ruoyi.project.ods.bus.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ruoyi.common.enums.StartStatus;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.ods.busConfig.domain.BusConfig;
import com.ruoyi.project.ods.busConfig.service.IBusConfigService;
import com.ruoyi.project.ods.busDetail.domain.BusDetail;
import com.ruoyi.project.ods.busDetail.service.IBusDetailService;
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
    @Autowired
    private IBusDetailService detailService;

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

    /**
     * 定时执行的文件导入的方法
     * */



    @GetMapping("/readFileAndInsert")
    @ResponseBody
    public String readFileAndInsert() throws IOException {
        long start=System.currentTimeMillis();

        //文件夹所在路径
        String filePath="F:\\dev\\document\\ODS数据管理\\data";

        //1查出未启动的业务主表
        List<Bus> busList=busService.selectByBusConfig(new BusConfig(StartStatus.NoStart.getValue()));

        //2读入文件流
        File file = new File(filePath);
        if(file.isDirectory()){
            //假设一个文件夹中直接是要导入的文件
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                File readfile = fileList[i];
                if (!readfile.isDirectory()) {
                    String name=readfile.getName();
                    int r_c=0;
                    for(Bus bus : busList){

                        if(name.equals(bus.getFilename())){
                            r_c++;
                            //获取表明细
                            List<BusDetail> detailList=detailService.selectBusDetailByTableId(bus.getId());

                            //拼接sql
                            StringBuilder sb=new StringBuilder("insert into ");
                            sb.append(bus.getTablename());
                                //拼接key
                            Collections.sort(detailList, new Comparator<BusDetail>() {
                                @Override
                                public int compare(BusDetail o1, BusDetail o2) {
                                    return o1.getFieldlocation()-o2.getFieldlocation();
                                }
                            });
                            sb.append(" (");
                            for (BusDetail detail:detailList){
                                sb.append(detail.getFieldname()+",");
                            }
                            sb.deleteCharAt(sb.length()-1);
                            sb.append(") values ");


                            //读取文件（若文件过大看是否需要考虑：分模块读及多线程读）
                            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(readfile),"gbk"),5*1024*1024);// 用5M的缓冲读取文本文件
                            String line = "";
                            while((line = reader.readLine()) != null){
                                //获取每个字段的值，组装称(v,v,v,v)
                                String[] strs=line.split("\\|\\+\\|");//"|+|"
                                sb.append(" (");
                                for(i=0;i<strs.length;i++){
                                    //判断是否为空
                                    if(StringUtils.isEmpty(strs[i])){
                                        sb.append("null,");
                                        continue;
                                    }
                                    //判断字段类型。(以及是否主键？判断自增？)
                                    if(detailList.get(i).getFieldtype().equals("int")){
                                        sb.append(strs[i]+",");
                                    }else{
                                        sb.append("'"+strs[i]+"',");
                                    }
                                }
                                //若最后一个字段没有值
                                if(strs.length==detailList.size()-1){
                                    sb.append("null,");
                                }

                                sb.deleteCharAt(sb.length()-1);
                                sb.append("),");
                            }
                            sb.deleteCharAt(sb.length()-1);

                            //清理缓冲
                            reader.close();

                            //插入数据库
                            int count=busService.executeSql(sb.toString());
                            sb=null;
                            System.out.print("插入影响行数："+count);
                            break;
                        }
                    }
                    //内循环全部业务表读完做跳出？
                    if(r_c==busList.size()){
                        break;
                    }
                } /*else if (readfile.isDirectory()) {//递归
                    //readfile(readfile);
                }*/
            }
        }/*else{//直接对文件进行读取
            //readfile(readfile);
        }*/


        return  "用时："+(System.currentTimeMillis()-start)+"毫秒！";
    }
}
