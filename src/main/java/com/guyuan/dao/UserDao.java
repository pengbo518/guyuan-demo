package com.guyuan.dao;

import com.guyuan.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description: user
 * @version: v1.0
 * @create: 2019-07-14 15:10
 **/
@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

}
