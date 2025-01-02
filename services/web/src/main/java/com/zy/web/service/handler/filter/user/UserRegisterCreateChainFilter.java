package com.zy.web.service.handler.filter.user;

import com.zy.pattern.starter.chain.AbstractChainHandler;
import com.zy.web.common.enums.UserChainMarkEnum;
import com.zy.web.dto.req.UserRegisterReqDTO;

/**
 * 用户注册责任链过滤器
 */
public interface UserRegisterCreateChainFilter<T extends UserRegisterReqDTO> extends AbstractChainHandler<UserRegisterReqDTO> {

    @Override
    default String mark() {
        return UserChainMarkEnum.USER_REGISTER_FILTER.name();
    }
}
