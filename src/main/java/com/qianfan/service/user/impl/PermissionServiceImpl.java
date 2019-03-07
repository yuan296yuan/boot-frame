package com.qianfan.service.user.impl;

import com.qianfan.entity.TbSysPermission;
import com.qianfan.mapper.TbSysPermissionMapper;
import com.qianfan.service.user.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    TbSysPermissionMapper tbSysPermissionMapper;
    /**
     * 根据id获取权限信息
     *
     * @param id
     * @return
     */
    @Override
    public TbSysPermission getPermissionById(int id) {
        return tbSysPermissionMapper.selectByPrimaryKey(id);
    }
}
