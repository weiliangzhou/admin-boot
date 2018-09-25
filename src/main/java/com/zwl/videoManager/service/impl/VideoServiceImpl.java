package com.zwl.videoManager.service.impl;

import com.zwl.common.utils.ShiroUtils;
import com.zwl.videoManager.dao.VideoMapper;
import com.zwl.videoManager.domain.VideoDO;
import com.zwl.videoManager.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;


@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public VideoDO get(Integer id) {
        return videoMapper.get(id);
    }

    @Override
    public List<VideoDO> list(Map<String, Object> map) {
        return videoMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return videoMapper.count(map);
    }

    @Override
    public int save(VideoDO video) {
//        if (null == video) {
//            //TODO:提示错误
//        }
//        video.setMerchantId(ShiroUtils.getMerchantId());
//        video.setCreateTime(Calendar.getInstance().getTime());
//        video.setAvailable(1);
        return videoMapper.save(video);
    }

    @Override
    public int update(VideoDO video) {
        return videoMapper.update(video);
    }

    @Override
    public int remove(Integer id) {
        return videoMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return videoMapper.batchRemove(ids);
    }

}
