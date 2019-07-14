package com.guyuan.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

import java.util.Date;

/**
 * tb_user
 */
@javax.persistence.Entity
@Table(name = "tb_user")
@DynamicUpdate
@DynamicInsert
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean deleted;
    private Date gmtCreated;
    private Date gmtModify;
    private String attributes;
    private String phone;
    private String password;
    private String username;
    private Integer type;
}
