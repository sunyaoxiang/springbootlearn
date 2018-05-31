package com.spider.security.dao;

import com.spider.security.bean.RoleE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/30.
 */

/**
 * 数据服务
 */
@Repository
public interface RoleService extends CrudRepository<RoleE, String> {
    RoleE findById(Long id);
    List<RoleE> findBynameCn(String nameCn);
    List<RoleE> findBynameEn(String nameEn);
}
