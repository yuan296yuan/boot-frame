package com.qianfan.service.user;

import com.qianfan.entity.TbUserRole;

import java.util.List;

public interface IUserRoleService {

    /**
     * 跟userId查询用户用户角色表
     * @param userId
     * @return
     */
    public List<TbUserRole> getUserRoleByUserId(int userId);

    /**
     * 根据角色Id获取用户角色表信息
     * @param roleId
     * @return
     */
    public List<TbUserRole> getUserRoleByRoleId(int roleId);
}
