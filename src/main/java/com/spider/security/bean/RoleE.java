package com.spider.security.bean;

import javax.persistence.*;

/**
 * Created by yaoxiang.sun on 2018/5/30.
 */
@Entity
@Table(name = "role")
public class RoleE {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_cn")
    private String nameCn;

    @Column(name = "name_en")
    private String nameEn;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

//    public RoleE() {}

//    public RoleE(RoleE user) {
//        this.id = user.getId();
//        this.nameCn = user.getNameCn();
//        this.nameEn = user.getNameEn();
//    }

}
