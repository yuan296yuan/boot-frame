package com.qianfan.service.login;

import com.qianfan.entity.TbSysRole;
import com.qianfan.entity.TbSysUser;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface ILoginService {

    /**
     * 添加用户信息
     * @param userMap
     * @return
     */
    public TbSysUser addUserBean(Map<String,Object> userMap);

    /**
     * 添加角色信息
     * @param roleMap
     * @return
     */
    public TbSysRole addRoleBean(Map<String,Object> roleMap);


    /**
     * 密码MD5加密，获取密文
     * @param username
     * @param password
     * @param salt
     * @return
     */
    public String getSecurityPassword(String username, String password,String salt)throws NoSuchAlgorithmException;

}
