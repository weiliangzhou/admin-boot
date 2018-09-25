package com.zwl.classManager.service.impl;

import com.zwl.classManager.dao.MerchantMapper;
import com.zwl.classManager.domain.Merchant;
import com.zwl.classManager.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public Merchant getMerchantByMerchantId(String merchantId) {
        return merchantMapper.selectByMerchantId(merchantId);
    }
}
