package com.zwl.certificationManager.service;

import com.zwl.certificationManager.domain.UserCertificationDO;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 10:38:51
 */
public interface UserCertificationService {

    UserCertificationDO get(Long id);

    List<UserCertificationDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserCertificationDO userCertification);

    int update(UserCertificationDO userCertification);

    int remove(Long id);

    int batchRemove(Long[] ids);

    String getIdCardByUserId(String userId);
}
