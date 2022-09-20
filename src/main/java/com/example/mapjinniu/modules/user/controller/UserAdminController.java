package com.example.mapjinniu.modules.user.controller;


import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.example.mapjinniu.common.CommonResult;
import com.example.mapjinniu.common.ResultCode;
import com.example.mapjinniu.common.Table;

import com.example.mapjinniu.modules.user.model.UserAdmin;
import com.example.mapjinniu.modules.user.service.UserAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lly
 * @since 2022-09-04
 */
@RestController
@RequestMapping("/user")
public class UserAdminController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserAdminController.class);
    @Autowired
    private UserAdminService userAdminService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Table>> listUserAdmin() {
        List<UserAdmin> userAdminList = userAdminService.list();
        SimpleDateFormat formatter_time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String[] headerNames_0 = new String[]{"id", "姓名","电话", "微信","职务","所在围栏id","所在街道",};
        String[] dataNames_0 = new String[]{"id", "name", "tel","vx","title","fenceId","street"};
        JSONArray data = new JSONArray();
        List<Table> tables = new ArrayList<>();
        for (UserAdmin userAdmin : userAdminList) {
            JSONObject makeJson = new JSONObject();
            makeJson.put("id", userAdmin.getId());
            makeJson.put("name", userAdmin.getName());
            makeJson.put("tel", userAdmin.getTel());
            makeJson.put("vx", userAdmin.getVx());
            makeJson.put("title", userAdmin.getTitle());
            makeJson.put("fenceId", userAdmin.getFenceId());
            makeJson.put("street", userAdmin.getStreet());
            if(userAdmin.getLocation()!=null)
            makeJson.put("location", userAdmin.getLocation());
            data.add(makeJson);

        }

        tables.add(new Table(headerNames_0,dataNames_0,data));

        return CommonResult.success(tables);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UserAdmin> createUser(@RequestBody UserAdmin userAdmin) {
        CommonResult<UserAdmin> commonResult = null;

        boolean count = userAdminService.save(userAdmin);
        if (count) {
            commonResult = CommonResult.success(userAdmin);
            LOGGER.debug("createBrand success:{}", userAdmin);
        } else {

            LOGGER.debug("createBrand failed:{}", userAdmin);
        }
        return commonResult;
    }

    @RequestMapping (value = "/delete",method = RequestMethod.DELETE)

    @ResponseBody
    public CommonResult deleteFenceById(Integer id){
        boolean count = userAdminService.removeById(id);
        if (count) {
            return CommonResult.success(1);

        }
        else  return CommonResult.failed(ResultCode.FAILED);
    }
}

