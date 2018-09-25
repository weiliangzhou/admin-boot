package com.zwl.common.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zwl.classManager.domain.ClaSetItemVo;
import com.zwl.classManager.domain.ClassCategoryItemVo;
import com.zwl.classManager.service.ClasetService;
import com.zwl.classManager.service.ClassCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 二师兄超级帅
 * @Title: 下拉框值
 * @ProjectName parent
 * @Description: TODO
 * @date 2018/7/2219:58
 */
@RestController
@RequestMapping("/items")
public class ItemsListController {
    @Autowired
    private ClasetService clasetService;

    @Autowired
    private ClassCategoryService classCategoryService;

    @PostMapping("/getClassSetItemsList")
    public String getClassSetItemsList(@RequestBody JSONObject jsonObject) {
        String merchantId = jsonObject.getString("merchantId");
        Integer categoryId = jsonObject.getInteger("categoryId");
        List<ClaSetItemVo> list = clasetService.getClassSetItemList(categoryId, merchantId);
        return JSON.toJSONString(list);
    }

    @PostMapping("/getClassCategoryItemsList")
    public String getClassCategoryItemsList(@RequestBody JSONObject jsonObject) {
        String merchantId = jsonObject.getString("merchantId");
        List<ClassCategoryItemVo> list = classCategoryService.getClassCategoryItemList(merchantId);
        return JSON.toJSONString(list);
    }

    @PostMapping("/getCategoryIdItemsList")
    public String getCategoryIdItemsList(@RequestBody JSONObject jsonObject) {
        String merchantId = jsonObject.getString("merchantId");
//        List<ClassSetItemVo> list = classSetService.getClassSetItemsList(categoryId, merchantId);
//        result.setData(list);
        Map map = new HashMap();
        map.put("id", 1);
        map.put("title", "精品课程1");
        Map map1 = new HashMap();
        map1.put("id", 2);
        map1.put("title", "精品课程2");
        List list = new ArrayList();
        list.add(map);
        list.add(map1);
        return JSON.toJSONString(list);
    }

    @PostMapping("/getUserLevelItemsList")
    public String getUserLevelItemsList(@RequestBody JSONObject jsonObject) {
        String merchantId = jsonObject.getString("merchantId");
//        List<ProductItemVo> productItemVoList = productService.getUserLevelItemsList(merchantId);
        Map map = new HashMap();
        map.put("level", 0);
        map.put("levelName", "会员");
        Map map1 = new HashMap();
        map1.put("level", 1);
        map1.put("levelName", "小班");
        Map map2 = new HashMap();
        map2.put("level", 4);
        map2.put("levelName", "学员");
        Map map3 = new HashMap();
        map3.put("level", 5);
        map3.put("levelName", "班长");
        Map map4 = new HashMap();
        map4.put("level", 6);
        map4.put("levelName", "院长");
        List list = new ArrayList();
        list.add(map);
        list.add(map1);
        return JSON.toJSONString(list);
    }
}
