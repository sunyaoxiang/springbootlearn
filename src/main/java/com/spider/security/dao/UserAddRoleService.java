package com.spider.security.dao;

import com.spider.security.bean.RoleE;
import com.spider.security.bean.UserE;
import com.spider.security.bean.UserRoleE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/30.
 */

/**
 * 为security :WebSecurityConfig提供auth生成类.
 * 由user表的nameEn:name_en起,获取对应user表信息(返回=0/=1,需要空异常处理),
 * 通过user_id在user_role表中获取到role对应信息(返回>=0,需要空异常处理)
 * 组装 org.springframework.security.core.userdetails.User ,添加用户名,密码,角色清单;
 * ! 注意 ! spring的 security 中的注解:@PreAuthorize("hasRole('admin')")  实际对应"ROLE_admin";
 * 请根据数据库中实际情况拼接角色类型.
 */
public class UserAddRoleService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserE user = userService.findBynameEn(username);
        if(user == null){
            throw new UsernameNotFoundException("not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        List<UserRoleE> userRoleE = userRoleService.findByuserId(user.getId());
        for (UserRoleE each : userRoleE) {
            RoleE roleE = roleService.findById(each.getRoleId());
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roleE.getNameEn()));
            System.err.println("username is " + username + ", " + roleE.getNameEn());
        }

        return new org.springframework.security.core.userdetails.User(user.getNameEn(),
                user.getNameEn(), authorities);
    }

}
