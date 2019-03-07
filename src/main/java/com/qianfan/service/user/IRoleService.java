package com.qianfan.service.user;

import com.qianfan.entity.TbSysRole;

import java.util.List;

public interface IRoleService {

    /**
     * 根据角色名称获取角色信息
     * @param roleName
     * @return
     */
    public List<TbSysRole> getRoleByRoleName(String roleName);

    /**
     * 根据角色id获取角色信息
     * @param roleId
     * @return
     */
    public TbSysRole getRoleByRoleId(int roleId);

    /**
     * 保存角色信息
     */
    public void save(TbSysRole role);
}
