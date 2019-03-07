package com.qianfan.controller;

import com.qianfan.common.MD5Tools;
import com.qianfan.entity.TbSysRole;
import com.qianfan.entity.TbSysUser;
import com.qianfan.service.login.ILoginService;
import com.qianfan.service.user.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private ILoginService loginServiceImpl;

    @Autowired
    IUserService userServiceImpl;

    //退出的时候是get请求，主要是用于退出
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    //post登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam Map map){
        try{
            //添加用户认证信息
            Subject subject = SecurityUtils.getSubject();
            String passworld=null;
            String username=null;
            if(null!=map.get("password")&&null!=map.get("username")){
                username=map.get("username").toString();
                TbSysUser user=userServiceImpl.getUserByUsername(username);
                if(null==user) throw  new NullPointerException("用户不存在！");
                passworld= username+ map.get("password").toString()+user.getSalt();
                passworld=MD5Tools.md5(passworld);
            }else {
                throw new Exception("账号或密码为空！");
            }
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, passworld);
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
            return "index";
        }catch (Exception ex){
            System.out.println("ex===>:"+ex.getMessage());
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView mv=new ModelAndView();
        System.out.println("访问：index");
        mv.setViewName("index");
        return mv;
    }

    //登出
    @RequestMapping(value = "/logout")
    public String logout(){
        return "logout";
    }

    //错误页面展示
    @RequestMapping(value = "/error",method = RequestMethod.POST)
    public String error(){
        return "error ok!";
    }

    //数据初始化
    @RequestMapping(value = "/addUser")
    public String addUser(@RequestBody Map<String,Object> map){
        TbSysUser user = loginServiceImpl.addUserBean(map);
        return "addUser is ok! \n" + user;
    }

    //角色初始化
    @RequestMapping(value = "/addRole")
    public String addRole(@RequestBody Map<String,Object> map){
        TbSysRole role = loginServiceImpl.addRoleBean(map);
        return "addRole is ok! \n" + role;
    }

    //注解的使用
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping(value = "/create")
    public String create(){
        return "Create success!";
    }
}
