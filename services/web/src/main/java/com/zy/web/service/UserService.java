package com.zy.web.service;

import com.zy.web.dto.resp.UserQueryRespDTO;
import jakarta.validation.constraints.NotEmpty;

public interface UserService {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户详细信息
     */
    UserQueryRespDTO queryUserByUsername(@NotEmpty String username);
}
