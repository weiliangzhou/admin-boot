package com.zwl.productManager.service.impl;

import com.zwl.common.utils.ShiroUtils;
import com.zwl.productManager.dao.ProductMapper;
import com.zwl.productManager.domain.ProductDO;
import com.zwl.productManager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDO get(Long id) {
        return productMapper.get(id);
    }

    @Override
    public List<ProductDO> list(Map<String, Object> map) {
        return productMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return productMapper.count(map);
    }

    @Override
    public int save(ProductDO product) {
        return productMapper.save(product);
    }

    @Override
    public int update(ProductDO product) {
        return productMapper.update(product);
    }

    @Override
    public int remove(Long id) {
        return productMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return productMapper.batchRemove(ids);
    }

    @Override
    public ProductDO getProductByLevel(Integer referrerLevel,String merchantId) {
        return productMapper.getProductByLevel(referrerLevel,merchantId);
    }

}
