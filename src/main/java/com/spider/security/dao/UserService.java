package com.spider.security.dao;

import com.spider.security.bean.UserE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yaoxiang.sun on 2018/5/30.
 */
@Repository
public interface UserService extends CrudRepository<UserE, String> {

    UserE findById(Long id);
    UserE findBynameCn(String name_cn);
    UserE findBynameEn(String namen);

}
