package com.qianfan.mapper;

import com.qianfan.entity.TbUserRole;
import com.qianfan.entity.TbUserRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbUserRoleMapper {
    int countByExample(TbUserRoleExample example);

    int deleteByExample(TbUserRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUserRole record);

    int insertSelective(TbUserRole record);

    List<TbUserRole> selectByExampleWithBLOBs(TbUserRoleExample example);

    List<TbUserRole> selectByExample(TbUserRoleExample example);

    TbUserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUserRole record, @Param("example") TbUserRoleExample example);

    int updateByExampleWithBLOBs(@Param("record") TbUserRole record, @Param("example") TbUserRoleExample example);

    int updateByExample(@Param("record") TbUserRole record, @Param("example") TbUserRoleExample example);

    int updateByPrimaryKeySelective(TbUserRole record);

    int updateByPrimaryKeyWithBLOBs(TbUserRole record);

    int updateByPrimaryKey(TbUserRole record);
}