package com.spider.security.dao;

import com.spider.security.bean.UserRoleE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yaoxiang.sun on 2018/5/30.
 */
@Repository
public interface UserRoleService extends CrudRepository<UserRoleE, String> {

    List<UserRoleE> findByuserId(Long userId);
//    @Query(value = "SELECT ul from UserRoleE ul  where ul.userId = :userId")
//    List<UserRoleE> findByuserId(@Param("userId") Long userId);

    List<UserRoleE> findById(Long Id);
}
