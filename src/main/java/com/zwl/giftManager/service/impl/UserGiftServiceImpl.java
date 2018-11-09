package com.zwl.giftManager.service.impl;

import com.zwl.giftManager.dao.UserGiftMapper;
import com.zwl.giftManager.domain.UserGiftDO;
import com.zwl.giftManager.service.UserGiftService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

@Service
public class UserGiftServiceImpl implements UserGiftService {
    @Autowired
    private UserGiftMapper userGiftMapper;

    @Override
    public UserGiftDO get(Long id) {
        return userGiftMapper.get(id);
    }

    @Override
    public List<UserGiftDO> list(Map<String, Object> map) {
        return userGiftMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userGiftMapper.count(map);
    }

    @Override
    public int save(UserGiftDO userGift) {
        return userGiftMapper.save(userGift);
    }

    @Override
    public int update(UserGiftDO userGift) {
        return userGiftMapper.update(userGift);
    }

    @Override
    public int remove(Long id) {
        return userGiftMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return userGiftMapper.batchRemove(ids);
    }

    @Override
    public int updateShipments(Long id, Integer expressCompany, String expressNo) {
        if (id == null) {
            throw new RuntimeException("订单号不能为空");
        }
        if (null == expressCompany) {
            throw new RuntimeException("请选择快递公司");
        }
        if (StringUtils.isBlank(expressNo)) {
            throw new RuntimeException("请输入快递单号");
        }
        UserGiftDO userGiftDO = this.get(id);
        if (null == userGiftDO) {
            throw new RuntimeException("无效订单");
        }
//        if (userGiftDO.getOrderState().intValue() == 1) {
//            throw new RuntimeException("请勿重复发货");
//        }
        return userGiftMapper.updateShipments(id, expressCompany, expressNo);
    }

}
