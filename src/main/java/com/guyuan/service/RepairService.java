package com.guyuan.service;

import com.guyuan.entity.RepairEntity;

import java.util.List;

public interface RepairService {
    RepairEntity save(RepairEntity repairEntity);
    List<RepairEntity> findAll();
    RepairEntity pass(Long id, Integer status);
}
