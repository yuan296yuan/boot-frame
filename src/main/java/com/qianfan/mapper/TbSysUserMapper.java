package com.qianfan.mapper;

import com.qianfan.entity.TbSysUser;
import com.qianfan.entity.TbSysUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSysUserMapper {
    int countByExample(TbSysUserExample example);

    int deleteByExample(TbSysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysUser record);

    int insertSelective(TbSysUser record);

    List<TbSysUser> selectByExampleWithBLOBs(TbSysUserExample example);

    List<TbSysUser> selectByExample(TbSysUserExample example);

    TbSysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysUser record, @Param("example") TbSysUserExample example);

    int updateByExampleWithBLOBs(@Param("record") TbSysUser record, @Param("example") TbSysUserExample example);

    int updateByExample(@Param("record") TbSysUser record, @Param("example") TbSysUserExample example);

    int updateByPrimaryKeySelective(TbSysUser record);

    int updateByPrimaryKeyWithBLOBs(TbSysUser record);

    int updateByPrimaryKey(TbSysUser record);
}