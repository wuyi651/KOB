package com.kob.backend.service.ranklist;

import com.alibaba.fastjson2.JSONObject;

/**
 * @author Wei
 * @version 1.0
 * @Description TODO
 */

public interface GetRankListService {
    JSONObject getList(Integer page);
}
