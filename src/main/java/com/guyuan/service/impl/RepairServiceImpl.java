package com.guyuan.service.impl;

import com.guyuan.dao.RepairDao;
import com.guyuan.entity.RepairEntity;
import com.guyuan.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.RepositoryQuery;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description: RepairServiceImpl
 * @version: v1.0
 * @create: 2019-07-14 15:13
 **/
@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    RepairDao repairDao;

    @Override
    public RepairEntity save(RepairEntity repairEntity) {
        return repairDao.save(repairEntity);
    }

    @Override
    public List<RepairEntity> findAll() {
        return repairDao.findAll();
    }

    @Override
    public RepairEntity pass(Long id, Integer status) {
        RepairEntity repairEntity = repairDao.findById(id).get();
        repairEntity.setStatus(status);
        repairEntity.setGmtModify(new Date());
        return repairDao.save(repairEntity);
    }
}
