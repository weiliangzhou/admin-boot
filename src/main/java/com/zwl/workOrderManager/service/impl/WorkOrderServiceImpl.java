package com.zwl.workOrderManager.service.impl;

import com.zwl.workOrderManager.dao.WorkOrderMapper;
import com.zwl.workOrderManager.domain.WorkOrderDO;
import com.zwl.workOrderManager.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class WorkOrderServiceImpl implements WorkOrderService {
    @Autowired
    private WorkOrderMapper workOrderMapper;

    @Override
    public WorkOrderDO get(Long id) {
        return workOrderMapper.get(id);
    }

    @Override
    public List<WorkOrderDO> list(Map<String, Object> map) {
        return workOrderMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return workOrderMapper.count(map);
    }

    @Override
    public int save(WorkOrderDO workOrder) {
        return workOrderMapper.save(workOrder);
    }

    @Override
    public int update(WorkOrderDO workOrder) {
        return workOrderMapper.update(workOrder);
    }

    @Override
    public int remove(Long id) {
        return workOrderMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return workOrderMapper.batchRemove(ids);
    }

}
