package com.zwl.classManager.service;

import com.zwl.classManager.domain.Merchant;

/**
 * 商户service
 */
public interface MerchantService {
    Merchant getMerchantByMerchantId(String merchantId);
}
