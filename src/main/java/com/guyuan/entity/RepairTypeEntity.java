package com.guyuan.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import springfox.documentation.service.ApiListing;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description: type
 * @author: Mr.Liu
 * @version: v1.0
 * @create: 2019-07-14 15:44
 **/
@javax.persistence.Entity
@Table(name = "tb_repair")
@DynamicUpdate
@DynamicInsert
@Data
public class RepairTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer type;
    private String name;
}
