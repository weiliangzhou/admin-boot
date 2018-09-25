package com.zwl.videoManager.service;

import com.zwl.videoManager.domain.VideoDO;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 11:15:51
 */
public interface VideoService {

    VideoDO get(Integer id);

    List<VideoDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(VideoDO video);

    int update(VideoDO video);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
