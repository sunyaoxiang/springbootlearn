package com.spider.security.bean;

import javax.persistence.*;

/**
 * Created by yaoxiang.sun on 2018/5/30.
 */
/**
 * table:user_role
 * @param {Long} id;
 * @param {Long} userId from user_id;
 * @param {Long} roleId from role_id;
 */
@Entity
@Table(name = "user_role")
public class UserRoleE {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
