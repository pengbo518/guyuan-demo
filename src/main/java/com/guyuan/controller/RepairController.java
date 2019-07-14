package com.guyuan.controller;

import com.guyuan.entity.RepairEntity;
import com.guyuan.enums.RepairStatusEnum;
import com.guyuan.service.RepairService;
import com.guyuan.service.RepairTypeService;
import com.guyuan.utils.ResultVOUtil;
import com.guyuan.vo.RepairVO;
import com.guyuan.vo.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: RepairController
 * @version: v1.0
 * @create: 2019-07-14 15:14
 **/
@RestController
@RequestMapping(value = "/repair")
@Api(value = "报修流程", tags = {"报修流程接口"})
public class RepairController {

    @Autowired
    RepairService repairService;
    @Autowired
    RepairTypeService repairTypeService;

    /**
     * 申请报修
     * @param userId 用户ID
     * @param type 报修类型type
     * @param remark 报修原因
     * @return
     */
    @PostMapping(value = "/addRepair")
    @ApiOperation(value = "申请报修", notes = "申请报修")
    public ResponseEntity addRepair(Long userId, Integer type, String remark){
        RepairEntity repairEntity = new RepairEntity();
        repairEntity.setUserId(userId);
        repairEntity.setType(type);
        repairEntity.setRemark(remark);
        repairEntity.setStatus(RepairStatusEnum.APPPLY.getCode());
        RepairEntity save = repairService.save(repairEntity);
        RepairVO repairVO = new RepairVO();
        BeanUtils.copyProperties(save, repairVO);
        if(repairEntity.getStatus() == RepairStatusEnum.APPPLY.getCode()){
            repairVO.setStatusName(RepairStatusEnum.APPPLY.getMessage());
        }
        return ResultVOUtil.success(repairVO);
    }

    /**
     * 审批通过
     * @param repairId 申请记录主键ID
     * @return
     */
    @PostMapping(value = "/approval")
    @ApiOperation(value = "审批通过", notes = "审批通过")
    public ResponseEntity approval(Long repairId){
        RepairEntity repairEntity = repairService.pass(repairId, RepairStatusEnum.APPPLY_PASS.getCode());
        RepairVO repairVO = new RepairVO();
        BeanUtils.copyProperties(repairEntity, repairVO);
        if(repairEntity.getStatus() == RepairStatusEnum.APPPLY_PASS.getCode()){
            repairVO.setStatusName(RepairStatusEnum.APPPLY_PASS.getMessage());
        }
        return ResultVOUtil.success(repairVO);
    }

    /**
     * 存档
     * @param repairId 申请记录主键ID
     * @return
     */
    @PostMapping(value = "/onFile")
    @ApiOperation(value = "存档", notes = "存档")
    public ResponseEntity onFile(Long repairId){
        RepairEntity repairEntity = repairService.pass(repairId, RepairStatusEnum.ON_FILE.getCode());
        RepairVO repairVO = new RepairVO();
        BeanUtils.copyProperties(repairEntity, repairVO);
        if(repairEntity.getStatus() == RepairStatusEnum.ON_FILE.getCode()){
            repairVO.setStatusName(RepairStatusEnum.ON_FILE.getMessage());
        }
        return ResultVOUtil.success(repairVO);
    }

    /**
     * 查看所有报修记录
     * @return
     */
    @GetMapping(value = "/viewAllRepair")
    @ApiOperation(value = "查看所有报修记录", notes = "查看所有报修记录")
    public ResponseEntity viewAllRepair(){
        List<RepairEntity> allRepair = repairService.findAll();
        List<RepairVO> repairVOList = new ArrayList<>();
        allRepair.stream().forEach(i->{
            RepairVO repairVO = new RepairVO();
            BeanUtils.copyProperties(i, repairVO);
            if(i.getStatus() == RepairStatusEnum.APPPLY.getCode()){
                repairVO.setStatusName(RepairStatusEnum.APPPLY.getMessage());
            } if(i.getStatus() == RepairStatusEnum.APPPLY_PASS.getCode()){
                repairVO.setStatusName(RepairStatusEnum.APPPLY_PASS.getMessage());
            } if(i.getStatus() == RepairStatusEnum.ON_FILE.getCode()){
                repairVO.setStatusName(RepairStatusEnum.ON_FILE.getMessage());
            }
            repairVOList.add(repairVO);
        });
        return ResultVOUtil.success(repairVOList);
    }

}
