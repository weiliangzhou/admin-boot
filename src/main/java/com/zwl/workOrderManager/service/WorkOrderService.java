package com.zwl.workOrderManager.service;

import com.zwl.workOrderManager.domain.WorkOrderDO;

import java.util.List;
import java.util.Map;

/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-09-19 14:26:45
 */
public interface WorkOrderService {

    WorkOrderDO get(Long id);

    List<WorkOrderDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(WorkOrderDO workOrder);

    int update(WorkOrderDO workOrder);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
