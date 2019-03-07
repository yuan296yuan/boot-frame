package com.qianfan.service.login.impl;

import com.qianfan.common.MD5Tools;
import com.qianfan.entity.TbSysRole;
import com.qianfan.entity.TbSysUser;
import com.qianfan.service.login.ILoginService;
import com.qianfan.service.user.IRoleService;
import com.qianfan.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    IUserService userServiceImpl;
    @Autowired
    IRoleService roleServiceImpl;

    /**
     * 添加用户信息
     *
     * @param userMap
     * @return
     */
    @Override
    public TbSysUser addUserBean(Map<String, Object> userMap) {
        TbSysUser user =new TbSysUser();
        user.setName((String)userMap.get("username"));
        user.setPassword((String)userMap.get("password"));
        user.setSalt("888888");
        user.setState(1);
        user.setRemark((String)userMap.get("remark"));
        userServiceImpl.save(user);
        return user;
    }

    /**
     * 添加角色信息
     *
     * @param roleMap
     * @return
     */
    @Override
    public TbSysRole addRoleBean(Map<String, Object> roleMap) {
        TbSysRole role =new TbSysRole();
        role.setRole((String)roleMap.get("role"));
        role.setDescription((String)roleMap.get("description"));
        role.setAvailable(1);
        roleServiceImpl.save(role);
        return role;
    }

    /**
     * 密码MD5加密，获取密文
     *
     * @param username
     * @param password
     * @param salt
     * @return
     */
    @Override
    public String getSecurityPassword(String username, String password, String salt)throws NoSuchAlgorithmException {
        String sourceText=username+password+salt;
        String SsecurityPassword=MD5Tools.md5(sourceText);
        return SsecurityPassword;
    }


}
