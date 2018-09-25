package com.zwl.productManager.service;

import com.zwl.productManager.domain.ProductDO;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 15:00:27
 */
public interface ProductService {

    ProductDO get(Long id);

    List<ProductDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ProductDO product);

    int update(ProductDO product);

    int remove(Long id);

    int batchRemove(Long[] ids);


    ProductDO getProductByLevel(Integer referrerLevel, String merchantId);
}
