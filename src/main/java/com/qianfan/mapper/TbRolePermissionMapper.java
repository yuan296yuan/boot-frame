package com.qianfan.mapper;

import com.qianfan.entity.TbRolePermission;
import com.qianfan.entity.TbRolePermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRolePermissionMapper {
    int countByExample(TbRolePermissionExample example);

    int deleteByExample(TbRolePermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRolePermission record);

    int insertSelective(TbRolePermission record);

    List<TbRolePermission> selectByExampleWithBLOBs(TbRolePermissionExample example);

    List<TbRolePermission> selectByExample(TbRolePermissionExample example);

    TbRolePermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRolePermission record, @Param("example") TbRolePermissionExample example);

    int updateByExampleWithBLOBs(@Param("record") TbRolePermission record, @Param("example") TbRolePermissionExample example);

    int updateByExample(@Param("record") TbRolePermission record, @Param("example") TbRolePermissionExample example);

    int updateByPrimaryKeySelective(TbRolePermission record);

    int updateByPrimaryKeyWithBLOBs(TbRolePermission record);

    int updateByPrimaryKey(TbRolePermission record);
}