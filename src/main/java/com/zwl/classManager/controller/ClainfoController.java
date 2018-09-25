package com.zwl.classManager.controller;

import com.zwl.classManager.domain.ClaSetItemVo;
import com.zwl.classManager.domain.ClainfoDO;
import com.zwl.classManager.domain.ClassCategoryItemVo;
import com.zwl.classManager.service.ClainfoService;
import com.zwl.classManager.service.ClasetService;
import com.zwl.classManager.service.ClassCategoryService;
import com.zwl.classManager.service.GzhService;
import com.zwl.common.utils.*;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/classManager/claInfo")
@Slf4j
public class ClainfoController {
    @Autowired
    private ClainfoService clainfoService;
    @Autowired
    private ClasetService clasetService;
    @Autowired
    private GzhService gzhService;
    @Autowired
    private ClassCategoryService classCategoryService;

    @GetMapping()
    @RequiresPermissions("classInfo:classInfo")
    String Clainfo() {
        return "classManager/clainfo/clainfo";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("classInfo:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        String merchantId = ShiroUtils.getMerchantId();
        params.put("merchantId", merchantId);
        //查询列表数据
        Query query = new Query(params);
        List<ClainfoDO> clainfoList = clainfoService.list(query);
        //查询所有一级分类列表，放在classCategoryMap中
        List<ClassCategoryItemVo> classCategoryList = classCategoryService.getClassCategoryItemList(merchantId);
        Map classCategoryMap = new HashMap();
        Map setMap = new HashMap();
        for (ClassCategoryItemVo classCategoryItemVo : classCategoryList) {
            if (null == classCategoryItemVo) continue;
            classCategoryMap.put("" + classCategoryItemVo.getId(), classCategoryItemVo.getTitle());
            //查询每个一级分类下所有二级分类列表，放在setMap中
            List<ClaSetItemVo> clasetDOList = clasetService.getClassSetItemList(classCategoryItemVo.getId(), merchantId);
            for (ClaSetItemVo claSetItemVo : clasetDOList) {
                if (claSetItemVo == null)
                    continue;
                setMap.put("" + claSetItemVo.getId(), claSetItemVo.getTitle());
            }
        }
        for (ClainfoDO clainfoDO : clainfoList) {
            Integer claSetId = clainfoDO.getClassSetId();
            Integer categoryId = clainfoDO.getCategoryId();
            if (categoryId != null) {
                //该节课的一级分类id如果在classCategoryMap这个一级分类列表中，则设置该节课的一级分类名称
                clainfoDO.setCategoryName(classCategoryMap.containsKey("" + categoryId) ? classCategoryMap.get("" + categoryId).toString() : "");
            }
            if (claSetId != null) {
                //该节课的二级分类id如果在setMap这个二级分类列表中，则设置该节课的二级分类名称
                clainfoDO.setClaSetName(setMap.containsKey("" + claSetId) ? setMap.get("" + claSetId).toString() : "");
            }
        }
        int total = clainfoService.count(query);
        PageUtils pageUtils = new PageUtils(clainfoList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("classInfo:add")
    String add(Model model) {
        String merchantId = ShiroUtils.getMerchantId();
        model.addAttribute("merchantId", merchantId);
        return "classManager/clainfo/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("classInfo:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        ClainfoDO clainfo = clainfoService.get(id);
        Integer playTime = clainfo.getPlayTime();
        if (null != playTime) {
            Integer minute = playTime / 60;
            Integer second = playTime % 60;
            clainfo.setMinute(minute);
            clainfo.setSecond(second);
        }
        model.addAttribute("clainfo", clainfo);
        return "classManager/clainfo/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("classInfo:info")
    public R info(@PathVariable("id") Long id) {
        ClainfoDO clainfo = clainfoService.get(id);
        return R.ok().put("clainfo", clainfo);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    //@RequiresPermissions("classInfo:save")
    public R save(ClainfoDO clainfo) {
        clainfo.setMerchantId(ShiroUtils.getMerchantId());
        Integer minute = clainfo.getMinute();
        Integer second = clainfo.getSecond();
        if (null != minute && null != second) {
            Integer playTime = minute * 60 + second;
            clainfo.setPlayTime(playTime);
        }
        String contextText = EditUtil.delHtmlTag(clainfo.getContent());
        clainfo.setContentText(contextText);
        if (clainfoService.save(clainfo) > 0) {
            String className = clainfo.getTitle();
            String merchantId = clainfo.getMerchantId();
            Integer classSetId = clainfo.getClassSetId();
            String classType = clasetService.getClassNameByClassSet(classSetId);
            String teacherName = "徐东遥";
            SimpleDateFormat sdf_yMdHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String className, String classType, String teacherName, String classTime, String merchantId
            gzhService.sendGzhMsgByAll(className, classType, teacherName, sdf_yMdHms.format(new Date()), merchantId);
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    //@RequiresPermissions("classInfo:update")
    public R update(@ModelAttribute ClainfoDO clainfo) {
        Integer minute = clainfo.getMinute();
        Integer second = clainfo.getSecond();
        if (null != minute && null != second) {
            Integer playTime = minute * 60 + second;
            clainfo.setPlayTime(playTime);
        }
        String contextText = EditUtil.delHtmlTag(clainfo.getContent());
        clainfo.setContentText(contextText);
        clainfoService.update(clainfo);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("classInfo:remove")
    public R remove(Long id) {
        if (clainfoService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("classInfo:remove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        clainfoService.batchRemove(ids);

        return R.ok();
    }


}
