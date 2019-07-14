package com.guyuan.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

import java.util.Date;

/**
 * tb_repair
 */
@javax.persistence.Entity
@Table(name = "tb_repair")
@DynamicUpdate
@DynamicInsert
@Data
public class RepairEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean deleted;
    private Date gmtCreated;
    private Date gmtModify;
    private String attributes;
    private Long userId;
    private Integer type;
    private String remark;
    private Integer status;
}
