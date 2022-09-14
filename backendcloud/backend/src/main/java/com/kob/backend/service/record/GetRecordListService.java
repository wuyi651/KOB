package com.kob.backend.service.record;

import com.alibaba.fastjson2.JSONObject;

/**
 * @author Wei
 * @version 1.0
 * @Description TODO
 */

public interface GetRecordListService {
    JSONObject getList(Integer page);
}
