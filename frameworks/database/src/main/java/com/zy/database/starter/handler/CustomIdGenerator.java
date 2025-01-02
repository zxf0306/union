package com.zy.database.starter.handler;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.zy.distributeId.starter.toolkit.SnowflakeIdUtil;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Number nextId(Object entity) {
        return SnowflakeIdUtil.nextId();
    }
}
