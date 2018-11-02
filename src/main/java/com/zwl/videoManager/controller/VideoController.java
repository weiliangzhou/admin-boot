package com.zwl.videoManager.controller;

import com.zwl.common.utils.*;
import com.zwl.videoManager.domain.VideoDO;
import com.zwl.videoManager.service.VideoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 11:15:51
 */
@Controller
@RequestMapping("/videoManager")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping()
    @RequiresPermissions("video:video")
    public String Video() {
        return "videoManager/video";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("video:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        String merchantId = ShiroUtils.getMerchantId();
        params.put("merchantId",merchantId);
        //查询列表数据
        Query query = new Query(params);
        List<VideoDO> videoList = videoService.list(query);
        int total = videoService.count(query);
        PageUtils pageUtils = new PageUtils(videoList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    //@RequiresPermissions("blog:bComments")
    public String add() {
        return "videoManager/add";
    }

    @GetMapping("/edit/{id}")
//    @RequiresPermissions("video:update")
    public String edit(ModelMap model, @PathVariable("id") Integer id) {
        VideoDO video = videoService.get(id);
        Integer playTime = video.getPlayTime();
        if(null != playTime){
            Integer minute = playTime/60;
            Integer second = playTime%60;
            video.setMinute(minute);
            video.setSecond(second);
        }
        model.addAttribute("Video", video);
        return "videoManager/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("video:info")
    public R info(@PathVariable("id") Integer id) {
        VideoDO video = videoService.get(id);
        return R.ok().put("video", video);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("video:save")
    public R save(@ModelAttribute VideoDO video) {
        video.setMerchantId(ShiroUtils.getMerchantId());
        Integer minute = video.getMinute();
        Integer second = video.getSecond();
        if(null != minute && null != second){
            Integer playTime = minute * 60 + second;
            video.setPlayTime(playTime);
        }
//        String contextText = EditUtil.delHtmlTag(video.getContent());
//        video.setContentText(contextText);
        if (videoService.save(video) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("video:update")
    @ResponseBody
    public R update(@ModelAttribute VideoDO video) {
        Integer minute = video.getMinute();
        Integer second = video.getSecond();
        if(null != minute && null != second){
            Integer playTime = minute * 60 + second;
            video.setPlayTime(playTime);
        }
//        String contextText = EditUtil.delHtmlTag(video.getContent());
//        video.setContentText(contextText);
        videoService.update(video);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("video:delete")
    public R remove(Integer id) {
        if (videoService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("video:delete")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        videoService.batchRemove(ids);

        return R.ok();
    }

}
