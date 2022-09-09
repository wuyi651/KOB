package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Wei
 * @version 1.0
 * @Description TODO
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
