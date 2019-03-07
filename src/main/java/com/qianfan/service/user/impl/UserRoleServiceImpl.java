package com.qianfan.service.user.impl;

import com.qianfan.entity.TbUserRole;
import com.qianfan.entity.TbUserRoleExample;
import com.qianfan.mapper.TbUserRoleMapper;
import com.qianfan.service.user.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements IUserRoleService{

    @Autowired
    TbUserRoleMapper tbUserRoleMapper;
    /**
     * 跟userId查询用户用户角色表
     *
     * @param userId
     * @return
     */
    @Override
    public List<TbUserRole> getUserRoleByUserId(int userId) {
        TbUserRoleExample userRoleExample=new TbUserRoleExample();
        TbUserRoleExample.Criteria userRoleCri=userRoleExample.createCriteria();
        userRoleCri.andUidEqualTo(userId);
        List<TbUserRole> tbUserRoles=tbUserRoleMapper.selectByExample(userRoleExample);
        return tbUserRoles;
    }

    /**
     * 根据角色Id获取用户角色表信息
     *
     * @param roleId
     * @return
     */
    @Override
    public List<TbUserRole> getUserRoleByRoleId(int roleId) {
        TbUserRoleExample userRoleExample=new TbUserRoleExample();
        TbUserRoleExample.Criteria userRoleCri=userRoleExample.createCriteria();
        userRoleCri.andRoleIdEqualTo(roleId);
        List<TbUserRole> tbUserRoles=tbUserRoleMapper.selectByExample(userRoleExample);
        return tbUserRoles;
    }
}
