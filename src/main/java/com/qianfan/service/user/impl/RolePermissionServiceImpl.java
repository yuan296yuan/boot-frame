package com.qianfan.service.user.impl;

import com.qianfan.entity.TbRolePermission;
import com.qianfan.entity.TbRolePermissionExample;
import com.qianfan.mapper.TbRolePermissionMapper;
import com.qianfan.service.user.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements IRolePermissionService {

    @Autowired
    TbRolePermissionMapper tbRolePermissionMapper;
    /**
     * 根据roleid获取角色权限表信息
     *
     * @param roleId
     * @return
     */
    @Override
    public List<TbRolePermission> getRolePermissionByRoleId(int roleId) {
        TbRolePermissionExample example=new TbRolePermissionExample();
        TbRolePermissionExample.Criteria criteria=example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<TbRolePermission> rolePermissions=tbRolePermissionMapper.selectByExample(example);
        return rolePermissions;
    }

    /**
     * 根据permissionId获取角色权限表信息
     *
     * @param permissionId
     * @return
     */
    @Override
    public List<TbRolePermission> getRolePermissionByPermissionId(int permissionId) {
        TbRolePermissionExample example=new TbRolePermissionExample();
        TbRolePermissionExample.Criteria criteria=example.createCriteria();
        criteria.andPermissionIdEqualTo(permissionId);
        List<TbRolePermission> rolePermissions=tbRolePermissionMapper.selectByExample(example);
        return rolePermissions;
    }
}
