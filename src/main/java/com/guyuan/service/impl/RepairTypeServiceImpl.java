package com.guyuan.service.impl;

import com.guyuan.dao.RepairTypeDao;
import com.guyuan.entity.RepairTypeEntity;
import com.guyuan.service.RepairTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @description: RepairTypeServiceImpl
 * @version: v1.0
 * @create: 2019-07-14 15:47
 **/
@Service
public class RepairTypeServiceImpl implements RepairTypeService {

    @Autowired
    RepairTypeDao repairTypeDao;

    @Override
    public RepairTypeEntity findById(Long id) {

        RepairTypeEntity repairTypeEntity = repairTypeDao.findById(id).get();
        return repairTypeEntity;
    }
}
