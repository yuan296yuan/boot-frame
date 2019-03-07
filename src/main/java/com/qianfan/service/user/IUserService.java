package com.qianfan.service.user;

import com.qianfan.entity.TbSysUser;
import com.qianfan.entity.TbSysUserExample;

import java.util.List;

public interface IUserService {
    /**
     * 查询用户信息
     */
    public TbSysUser getUserByUsername(String username);

    /**
     * 查询用户信息
     * @param ue
     * @return
     */
    public List<TbSysUser> getUsers(TbSysUserExample ue);

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    public TbSysUser getUserByUserId(int id);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public void save(TbSysUser user);
}
