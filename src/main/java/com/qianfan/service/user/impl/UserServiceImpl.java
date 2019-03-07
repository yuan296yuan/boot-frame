package com.qianfan.service.user.impl;

import com.qianfan.entity.TbSysUser;
import com.qianfan.entity.TbSysUserExample;
import com.qianfan.mapper.TbSysUserMapper;
import com.qianfan.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    TbSysUserMapper tbSysUserMapper;

    /**
     * 根据username获取用户信息
     * @param username
     * @return
     */
    @Override
    public TbSysUser getUserByUsername(String username) {
        if(StringUtils.isEmpty(username)) throw new NullPointerException("username 为空");
        TbSysUserExample ue=new TbSysUserExample();
        TbSysUserExample.Criteria criteria=ue.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbSysUser> list_user=tbSysUserMapper.selectByExample(ue);
        if(list_user==null) throw new NullPointerException("用户不存在");
        return list_user.get(0);
    }

    /**
     * 查询用户信息
     *
     * @param ue
     * @return
     */
    @Override
    public List<TbSysUser> getUsers(TbSysUserExample ue) {
        List<TbSysUser> list=tbSysUserMapper.selectByExample(ue);
        return list;
    }

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public TbSysUser getUserByUserId(int id) {
        if(StringUtils.isEmpty(id)) throw new NullPointerException("id 为空");
        TbSysUser user=tbSysUserMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    @Override
    public void save(TbSysUser user) {
        tbSysUserMapper.insert(user);
    }
}
