package com.qianfan.service.user.impl;

import com.qianfan.entity.TbSysRole;
import com.qianfan.entity.TbSysRoleExample;
import com.qianfan.mapper.TbSysRoleMapper;
import com.qianfan.service.user.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    TbSysRoleMapper tbSysRoleMapper;

    @Override
    public List<TbSysRole> getRoleByRoleName(String roleName) {
        if(StringUtils.isEmpty(roleName)) throw new NullPointerException("角色名为空");
        TbSysRoleExample roleExample=new TbSysRoleExample();
        TbSysRoleExample.Criteria ca=roleExample.createCriteria();
        ca.andRoleEqualTo(roleName);
        List<TbSysRole> roleList=tbSysRoleMapper.selectByExample(roleExample);
        return roleList;
    }

    @Override
    public TbSysRole getRoleByRoleId(int roleId) {
        if(StringUtils.isEmpty(roleId)) throw new NullPointerException("角色ID为空");
        TbSysRole role=tbSysRoleMapper.selectByPrimaryKey(roleId);
        return role;
    }

    /**
     * 保存角色信息
     *
     * @param role
     */
    @Override
    public void save(TbSysRole role) {
        tbSysRoleMapper.insert(role);
    }
}
