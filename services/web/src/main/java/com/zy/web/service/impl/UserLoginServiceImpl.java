package com.zy.web.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zy.cache.DistributedCache;
import com.zy.common.toolkit.BeanUtil;
import com.zy.convention.exception.ServiceException;
import com.zy.pattern.starters.chain.AbstractChainContext;
import com.zy.web.common.enums.UserChainMarkEnum;
import com.zy.web.dao.entity.UserDO;
import com.zy.web.dao.entity.UserReuseDO;
import com.zy.web.dao.mapper.UserMapper;
import com.zy.web.dao.mapper.UserReuseMapper;
import com.zy.web.dto.req.UserRegisterReqDTO;
import com.zy.web.dto.resp.UserRegisterRespDTO;
import com.zy.web.service.UserLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.zy.web.common.enums.RedisKeyConstant.LOCK_USER_REGISTER;
import static com.zy.web.common.enums.RedisKeyConstant.USER_REGISTER_REUSE_SHARDING;
import static com.zy.web.common.enums.UserRegisterErrorCodeEnum.HAS_USERNAME_NOTNULL;
import static com.zy.web.common.enums.UserRegisterErrorCodeEnum.USER_REGISTER_FAIL;
import static com.zy.web.toolkit.UserReuseUtil.hashShardingIdx;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService {

    private final UserMapper userMapper;
    private final UserReuseMapper userReuseMapper;
    private final RedissonClient redissonClient;
    private final DistributedCache distributedCache;
    private final AbstractChainContext<UserRegisterReqDTO> abstractChainContext;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public UserRegisterRespDTO register(UserRegisterReqDTO requestParam) {
        abstractChainContext.handler(UserChainMarkEnum.USER_REGISTER_FILTER.name(), requestParam);
        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER + requestParam.getUsername());
        boolean tryLock = lock.tryLock();
        if (!tryLock) {
            throw new ServiceException(HAS_USERNAME_NOTNULL);
        }
        try {
            try {
                int inserted = userMapper.insert(BeanUtil.convert(requestParam, UserDO.class));
                if (inserted < 1) {
                    throw new ServiceException(USER_REGISTER_FAIL);
                }
            } catch (DuplicateKeyException dke) {
                log.error("用户名 [{}] 重复注册", requestParam.getUsername());
                throw new ServiceException(HAS_USERNAME_NOTNULL);
            }
            String username = requestParam.getUsername();
//            userReuseMapper.delete(Wrappers.update(new UserReuseDO(username)));
//            StringRedisTemplate instance = (StringRedisTemplate) distributedCache.getInstance();
//            instance.opsForSet().remove(USER_REGISTER_REUSE_SHARDING + hashShardingIdx(username), username);
        } finally {
            lock.unlock();
        }
        return BeanUtil.convert(requestParam, UserRegisterRespDTO.class);
    }
}
