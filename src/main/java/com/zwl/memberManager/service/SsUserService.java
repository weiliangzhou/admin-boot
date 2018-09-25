package com.zwl.memberManager.service;

import com.zwl.memberManager.domain.SsUserDO;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author 二师兄超级帅
 * @email 382308664@qq.com
 * @date 2018-08-27 16:35:27
 */
public interface SsUserService {
	
	SsUserDO get(Long id);
	
	List<SsUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SsUserDO ssUser);
	
	int update(SsUserDO ssUser);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	SsUserDO getUserByUserId(String userId);

	String getUserByRegisterMobile(String registerMobile);

    Integer getXiaXianCountByUserId(String userId, String merchantId);

	Integer getActualMoneyByUserId(String userId);

	SsUserDO getUserByPhone(String referrerPhone, String merchantId);

	Integer getTotalPerformanceByUserId(String userId, String merchantId);
}
