package com.zy.web.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.web.dao.entity.UserDO;

public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * 注销用户
     *
     * @param userDO 注销用户入参
     */
    void deletionUser(UserDO userDO);
}
