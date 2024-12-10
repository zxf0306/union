package com.zy.web.service.handler.filter.user;

import com.zy.convention.exception.ClientException;
import com.zy.web.dto.req.UserRegisterReqDTO;
import com.zy.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegisterCheckDeletionChainHandler implements UserRegisterCreateChainFilter<UserRegisterReqDTO>{

    private final UserService userService;

    @Override
    public void handler(UserRegisterReqDTO requestParam) {
        Integer userDeletionNum = userService.queryUserDeletionNum(requestParam.getIdType(), requestParam.getIdCard());
        if (userDeletionNum >= 5) {
            throw new ClientException("证件号多次注销账号已被加入黑名单");
        }
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
