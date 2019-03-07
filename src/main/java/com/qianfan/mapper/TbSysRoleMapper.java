package com.qianfan.mapper;

import com.qianfan.entity.TbSysRole;
import com.qianfan.entity.TbSysRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSysRoleMapper {
    int countByExample(TbSysRoleExample example);

    int deleteByExample(TbSysRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysRole record);

    int insertSelective(TbSysRole record);

    List<TbSysRole> selectByExampleWithBLOBs(TbSysRoleExample example);

    List<TbSysRole> selectByExample(TbSysRoleExample example);

    TbSysRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysRole record, @Param("example") TbSysRoleExample example);

    int updateByExampleWithBLOBs(@Param("record") TbSysRole record, @Param("example") TbSysRoleExample example);

    int updateByExample(@Param("record") TbSysRole record, @Param("example") TbSysRoleExample example);

    int updateByPrimaryKeySelective(TbSysRole record);

    int updateByPrimaryKeyWithBLOBs(TbSysRole record);

    int updateByPrimaryKey(TbSysRole record);
}