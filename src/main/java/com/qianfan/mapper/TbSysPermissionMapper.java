package com.qianfan.mapper;

import com.qianfan.entity.TbSysPermission;
import com.qianfan.entity.TbSysPermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSysPermissionMapper {
    int countByExample(TbSysPermissionExample example);

    int deleteByExample(TbSysPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysPermission record);

    int insertSelective(TbSysPermission record);

    List<TbSysPermission> selectByExample(TbSysPermissionExample example);

    TbSysPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysPermission record, @Param("example") TbSysPermissionExample example);

    int updateByExample(@Param("record") TbSysPermission record, @Param("example") TbSysPermissionExample example);

    int updateByPrimaryKeySelective(TbSysPermission record);

    int updateByPrimaryKey(TbSysPermission record);
}