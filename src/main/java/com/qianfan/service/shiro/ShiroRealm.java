package com.qianfan.service.shiro;

import com.qianfan.entity.TbRolePermission;
import com.qianfan.entity.TbSysUser;
import com.qianfan.entity.TbUserRole;
import com.qianfan.service.user.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    IUserService userServiceImpl;
    @Autowired
    IUserRoleService userRoleServiceImpl;
    @Autowired
    IRoleService roleServiceImpl;
    @Autowired
    IRolePermissionService rolePermissionServiceImpl;
    @Autowired
    IPermissionService permissionServiceImpl;

    /**
     * 角色权限添加
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String username=(String)principalCollection.getPrimaryPrincipal();
        TbSysUser user=userServiceImpl.getUserByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        List<TbUserRole> userRoles=userRoleServiceImpl.getUserRoleByUserId(user.getId());
        for(TbUserRole userRole:userRoles){
            //添加角色
            simpleAuthorizationInfo.addRole(roleServiceImpl.getRoleByRoleId(userRole.getRoleId()).getRole());
            for(TbRolePermission rolePermission:rolePermissionServiceImpl.getRolePermissionByRoleId(userRole.getRoleId())){
                simpleAuthorizationInfo.addStringPermission(permissionServiceImpl.getPermissionById(rolePermission.getPermissionId()).getPermission());
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        TbSysUser user = userServiceImpl.getUserByUsername(name);
        if (user == null) throw new NullPointerException("用户不存在");
        //这里验证authenticationToken和simpleAuthenticationInfo的信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
        return simpleAuthenticationInfo;
    }
}
