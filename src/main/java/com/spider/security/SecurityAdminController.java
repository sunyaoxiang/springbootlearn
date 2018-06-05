package com.spider.security;

import com.spider.security.bean.UserE;
import com.spider.security.dao.RoleService;
import com.spider.security.dao.UserRoleService;
import com.spider.security.dao.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by yaoxiang.sun on 2018/5/30.
 */
@Controller
@Slf4j
public class SecurityAdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/adminrequire", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('admin')")  // 实际对应ROLE_admin
    public String adminRequire(HttpServletResponse httpServletResponse) {
        System.out.println(httpServletResponse.getHeaderNames());
        log.info("This is only for admin.");
        return "This is only for admin.";
    }

    @ResponseBody
    @RequestMapping(value = "/developquire", method = RequestMethod.GET)
    @PreAuthorize("hasRole('develop')") // 实际对应ROLE_develop
    public String developRequire() {
        return "This is only for develop.";
    }


    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String userRequire(@PathVariable("id") Long id) {
        UserE user = userService.findById(id);
//        UserAddRoleService userAddRoleService = new UserAddRoleService();
//        Map map = userAddRoleService.addRole(user, userRoleService, roleService);
        return user.getNameEn();
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
