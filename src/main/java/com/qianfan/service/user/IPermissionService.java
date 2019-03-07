package com.qianfan.service.user;

import com.qianfan.entity.TbSysPermission;

import java.util.List;

public interface IPermissionService {
    /**
     * 根据id获取权限信息
     * @param id
     * @return
     */
    public TbSysPermission getPermissionById(int id);

}
