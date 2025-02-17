package com.zy.web.controller;

import com.zy.convention.starter.result.Result;
import com.zy.starter.idempotent.annotation.Idempotent;
import com.zy.starter.idempotent.enums.IdempotentSceneEnum;
import com.zy.starter.idempotent.enums.IdempotentTypeEnum;
import com.zy.web.dto.req.UserDeletionReqDTO;
import com.zy.web.dto.req.UserUpdateReqDTO;
import com.zy.web.dto.resp.UserQueryRespDTO;
import com.zy.web.service.UserLoginService;
import com.zy.web.service.UserService;
import com.zy.webs.starter.Results;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制层
 */
@RestController
@RequiredArgsConstructor
public class UserInfoController {

    private final UserLoginService userLoginService;
    private final UserService userService;

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/api/user-service/query")
    @Idempotent(
            uniqueKeyPrefix = "index12306-user:lock_passenger-alter:",
            key = "T(com.zy.starter.user.core.UserContext).getUsername()",
            type = IdempotentTypeEnum.SPEL,
            scene = IdempotentSceneEnum.RESTAPI,
            message = "测试中，请稍后再试..."
    )
    public Result<UserQueryRespDTO> queryUserByUsername(@RequestParam("username") @NotEmpty String username) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Results.success(userService.queryUserByUsername(username));
    }

    /**
     * 修改用户
     */
    @PostMapping("/api/user-service/update")
    public Result<Void> update(@RequestBody @Valid UserUpdateReqDTO requestParam) {
        userService.update(requestParam);
        return Results.success();
    }


    /**
     * 注销用户
     */
    @PostMapping("/api/user-service/deletion")
    public Result<Void> deletion(@RequestBody @Valid UserDeletionReqDTO requestParam) {
        userLoginService.deletion(requestParam);
        return Results.success();
    }
}
