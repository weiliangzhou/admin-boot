package com.zwl.classManager.controller;

import com.zwl.classManager.domain.ClainfoDO;
import com.zwl.classManager.domain.ClasetDO;
import com.zwl.classManager.domain.ClassCategoryItemVo;
import com.zwl.classManager.service.ClainfoService;
import com.zwl.classManager.service.ClasetService;
import com.zwl.classManager.service.ClassCategoryService;
import com.zwl.classManager.service.GzhService;
import com.zwl.common.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-28 21:17:13
 */
@Controller
@RequestMapping("/classManager/claSet")
public class ClasetController {
    @Autowired
    private ClasetService clasetService;
    @Autowired
    private GzhService gzhService;
    @Autowired
    private ClassCategoryService classCategoryService;
    @Autowired
    private ClainfoService clainfoService;

    @GetMapping()
    @RequiresPermissions("claset:claset")
    String Claset() {
        return "classManager/claset/claset";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("claset:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        String merchantId = ShiroUtils.getMerchantId();
        params.put("merchantId", merchantId);
        //查询列表数据
        Query query = new Query(params);
        List<ClasetDO> clasetList = clasetService.list(query);
        //查询所有一级分类列表，放在classCategoryMap中
        List<ClassCategoryItemVo> classCategoryList = classCategoryService.getClassCategoryItemList(merchantId);
        Map classCategoryMap = new HashMap();
        for(ClassCategoryItemVo classCategoryItemVo:classCategoryList){
            if(null == classCategoryItemVo)continue;
            classCategoryMap.put(""+classCategoryItemVo.getId(),classCategoryItemVo.getTitle());
        }
        for (ClasetDO clasetDO : clasetList) {
            Integer categoryId = clasetDO.getCategoryId();
            if(categoryId != null){
                //该套课的一级分类id如果在classCategoryMap这个一级分类列表中，则设置该套课的一级分类名称
                clasetDO.setCategoryName(classCategoryMap.containsKey(""+categoryId) ? classCategoryMap.get(""+categoryId).toString():"");
            }
        }
        int total = clasetService.count(query);
        PageUtils pageUtils = new PageUtils(clasetList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("claset:add")
    String add(Model model) {
        String merchantId = ShiroUtils.getMerchantId();
        model.addAttribute("merchantId", merchantId);
        return "classManager/claset/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("claset:edit")
    String edit(Model model, @PathVariable("id") Long id) {
        ClasetDO claset = clasetService.get(id);
        model.addAttribute("claset", claset);
        return "classManager/claset/edit";
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("claset:info")
    public R info(@PathVariable("id") Long id) {
        ClasetDO claset = clasetService.get(id);
        return R.ok().put("claset", claset);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("claset:save")
    public R save(ClasetDO claset) {
        claset.setMerchantId(ShiroUtils.getMerchantId());
//        claset.setAvailable(1);
        String contextText = EditUtil.delHtmlTag(claset.getContent());
        String teacherName = "徐东遥";
        SimpleDateFormat sdf_yMdHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        claset.setContentText(contextText);
        if (clasetService.save(claset) > 0) {
            String className = claset.getTitle();
            String merchantId = claset.getMerchantId();
            gzhService.sendGzhMsgByAll(className, claset.getTitle(), teacherName, sdf_yMdHms.format(new Date()), merchantId);
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("claset:update")
    @ResponseBody
    public R update(@ModelAttribute ClasetDO claset) {
        String contextText = EditUtil.delHtmlTag(claset.getContent());
        claset.setContentText(contextText);
        Integer categoryId = claset.getCategoryId();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("classSetId",claset.getId());
        //查找该套课下的节课
        List<ClainfoDO> clainfoDOList = clainfoService.list(map);
        for(ClainfoDO clainfoDO:clainfoDOList){
            clainfoDO.setCategoryId(categoryId);
            //当套课的所属分类改变，套课下的所有节课的所属分类也随之改变
            clainfoService.update(clainfoDO);
        }
        clasetService.update(claset);
        return R.ok();
//        if (clasetService.update(claset) > 0) {
//            return R.ok();
//        }
//        return R.error();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("claset:remove")
    public R remove(Long id) {
        if (clasetService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("claset:remove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        clasetService.batchRemove(ids);

        return R.ok();
    }

}
