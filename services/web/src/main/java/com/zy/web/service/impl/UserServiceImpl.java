package com.zy.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zy.common.toolkit.BeanUtil;
import com.zy.convention.exception.ClientException;
import com.zy.web.dao.entity.UserDO;
import com.zy.web.dao.entity.UserDeletionDO;
import com.zy.web.dao.mapper.UserDeletionMapper;
import com.zy.web.dao.mapper.UserMapper;
import com.zy.web.dto.req.UserUpdateReqDTO;
import com.zy.web.dto.resp.UserQueryActualRespDTO;
import com.zy.web.dto.resp.UserQueryRespDTO;
import com.zy.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserDeletionMapper userDeletionMapper;

    @Override
    public UserQueryRespDTO queryUserByUserId(String userId) {
        return null;
    }

    @Override
    public UserQueryRespDTO queryUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = userMapper.selectOne(queryWrapper);
        if (userDO == null) {
            throw new ClientException("用户不存在，请检查用户名是否正确");
        }
        return BeanUtil.convert(userDO, UserQueryRespDTO.class);
    }

    @Override
    public UserQueryActualRespDTO queryActualUserByUsername(String username) {
        return null;
    }

    @Override
    public Integer queryUserDeletionNum(Integer idType, String idCard) {
        LambdaQueryWrapper<UserDeletionDO> queryWrapper = Wrappers.lambdaQuery(UserDeletionDO.class)
                .eq(UserDeletionDO::getIdType, idType)
                .eq(UserDeletionDO::getIdCard, idCard);
        // TODO 此处应该先查缓存
        Long deletionCount = userDeletionMapper.selectCount(queryWrapper);
        return Optional.ofNullable(deletionCount).map(Long::intValue).orElse(0);
    }

    @Override
    public void update(UserUpdateReqDTO requestParam) {

    }
}
