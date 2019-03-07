package com.qianfan.service.user;

import com.qianfan.entity.TbRolePermission;

import java.util.List;

public interface IRolePermissionService {

    /**
     * 根据roleid获取角色权限表信息
     * @param roleId
     * @return
     */
    public List<TbRolePermission> getRolePermissionByRoleId(int roleId);

    /**
     * 根据permissionId获取角色权限表信息
     * @param permissionId
     * @return
     */
    public List<TbRolePermission> getRolePermissionByPermissionId(int permissionId);
}
