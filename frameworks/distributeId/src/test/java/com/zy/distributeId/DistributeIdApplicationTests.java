package com.zy.distributeId;

import com.zy.distributeId.toolkit.SnowflakeIdUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DistributeIdApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(SnowflakeIdUtil.nextId());
    }

}
