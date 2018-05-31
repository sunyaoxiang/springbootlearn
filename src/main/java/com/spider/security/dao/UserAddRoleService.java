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
