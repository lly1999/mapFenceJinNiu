package com.example.mapjinniu.modules.fence.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.example.mapjinniu.common.CommonResult;
import com.example.mapjinniu.common.ResultCode;
import com.example.mapjinniu.common.Table;
import com.example.mapjinniu.modules.fence.model.Fence;
import com.example.mapjinniu.modules.fence.service.FenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lly
 * @since 2022-09-04
 */
@RestController
@RequestMapping("/fence")
public class FenceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FenceController.class);

    @Autowired
    private FenceService fenceService;



    @RequestMapping("/get")

    @ResponseBody
    public Fence getAllFence(){
        return fenceService.getById(1);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Fence> createFence(@RequestBody Fence fence) {
        CommonResult<Fence> commonResult = null;

        boolean count = fenceService.save(fence);
        if (count) {
            commonResult = CommonResult.success(fence);
            LOGGER.debug("createBrand success:{}", fence);
        } else {

            LOGGER.debug("createBrand failed:{}", fence);
        }
        return commonResult;
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult <List<Table>> listFence() {
        List<Fence> fenceList=fenceService.list();
        SimpleDateFormat formatter_time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String[] headerNames_0 = new String[]{"围栏名称", "围栏编号","创建者", "创建时间","围栏人员"};
        String[] dataNames_0 = new String[]{"val0", "val1", "val2","val3","val4"};
        JSONArray data = new JSONArray();
        List<Table> tables = new ArrayList<>();
        for (Fence fence : fenceList) {
            JSONObject makeJson = new JSONObject();
            makeJson.put("val0", fence.getName());
            makeJson.put("val1", fence.getId());
            makeJson.put("val2", fence.getCreator());
            makeJson.put("val3", formatter_time.format(fence.getCreateTime()));
            makeJson.put("pointList", (fence.getPointList()).replace("],","],a"));

            data.add(makeJson);

        }





       /* List list = Arrays.asList(test);
        System.out.println(list);
        Collections.replaceAll(list,"],","],a");
        System.out.println(list);*/
        tables.add(new Table(headerNames_0,dataNames_0,data));

        return CommonResult.success(tables);
    }


    @RequestMapping (value = "/delete",method = RequestMethod.DELETE)

    @ResponseBody
    public CommonResult deleteFenceById(Integer id){
        boolean count = fenceService.removeById(id);
        if (count) {
        return CommonResult.success(1);

    }
    else  return CommonResult.failed(ResultCode.FAILED);
    }



@RequestMapping(value = "/test",method = RequestMethod.GET)

@ResponseBody
    public void test(){

    Fence fence1 = new Fence();
    fence1.setName("金牛区围栏");
    String pointList = "yedsy";


    fence1.setCreateTime(new Date());
    fence1.setCreator("吴教授");

System.out.println(new Date());
    fenceService.save(fence1);
}


}

