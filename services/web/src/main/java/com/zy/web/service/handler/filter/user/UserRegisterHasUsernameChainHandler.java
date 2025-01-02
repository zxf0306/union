package com.zy.web.service.handler.filter.user;

import com.zy.convention.starter.exception.ClientException;
import com.zy.web.common.enums.UserRegisterErrorCodeEnum;
import com.zy.web.dto.req.UserRegisterReqDTO;
import com.zy.web.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 用户注册用户名唯一检验
 */
@Component
@RequiredArgsConstructor
public final class UserRegisterHasUsernameChainHandler implements UserRegisterCreateChainFilter<UserRegisterReqDTO> {

    private final UserLoginService userLoginService;

    @Override
    public void handler(UserRegisterReqDTO requestParam) {
        if (!userLoginService.hasUsername(requestParam.getUsername())) {
            throw new ClientException(UserRegisterErrorCodeEnum.HAS_USERNAME_NOTNULL);
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
