package com.zy.web.service;

import com.zy.web.dto.req.UserRegisterReqDTO;
import com.zy.web.dto.resp.UserRegisterRespDTO;

public interface UserLoginService {

    /**
     * 用户注册
     *
     * @param requestParam 用户注册入参
     * @return 用户注册返回结果
     */
    UserRegisterRespDTO register(UserRegisterReqDTO requestParam);
}
