package com.qianfan.controller.system;

import com.alibaba.fastjson.JSON;
import com.qianfan.common.LayuiBean;
import com.qianfan.entity.TbSysUser;
import com.qianfan.entity.TbSysUserExample;
import com.qianfan.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/system")
public class UserController {

    @Autowired
    IUserService userServiceImpl;


    @RequestMapping(value = "/initUser")
    public ModelAndView initUser(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/system/user");
        return  mv;
    }

    @RequestMapping(value = "/queryUser",method = RequestMethod.POST)
    @ResponseBody
    public String queryUser(@RequestParam Map map){
        TbSysUserExample tue=new TbSysUserExample();
        TbSysUserExample.Criteria criteria=tue.createCriteria();
        List<TbSysUser> list=userServiceImpl.getUsers(tue);
        LayuiBean returnBean=new LayuiBean();
        returnBean.setData(list);
        String returnJson= JSON.toJSONString(returnBean);
        System.out.println(returnJson);
        return returnJson;
    }

}
