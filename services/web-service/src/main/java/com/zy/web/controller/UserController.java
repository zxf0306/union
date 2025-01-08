package com.zy.web.controller;

import com.zy.convention.starter.result.Result;
import com.zy.web.dto.req.UserRegisterReqDTO;
import com.zy.web.dto.resp.UserQueryRespDTO;
import com.zy.web.dto.resp.UserRegisterRespDTO;
import com.zy.web.service.UserService;
import com.zy.web.service.UserLoginService;
import com.zy.webs.starter.Results;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserLoginService userLoginService;

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/user-service/query")
    public Result<UserQueryRespDTO> queryUserByUsername(@RequestParam("username") @NotEmpty String username) {
        return Results.success(userService.queryUserByUsername(username));
    }

    /**
     * 注册用户
     */
    @PostMapping("/api/user-service/register")
    public Result<UserRegisterRespDTO> register(@RequestBody @Valid UserRegisterReqDTO requestParam) {
        return Results.success(userLoginService.register(requestParam));
    }


}
