package com.zwl.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zwl.common.domain.SysLogDO;
import com.zwl.common.domain.PageDO;
import com.zwl.common.utils.Query;
@Service
public interface LogService {
	PageDO<SysLogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(List<Long> ids);
}
