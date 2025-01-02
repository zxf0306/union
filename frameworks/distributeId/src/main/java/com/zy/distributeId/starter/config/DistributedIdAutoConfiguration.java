package com.zy.distributeId.starter.config;

import com.zy.base.starter.ApplicationContextHolder;
import com.zy.distributeId.starter.core.snowflake.LocalRedisWorkIdChoose;
import com.zy.distributeId.starter.core.snowflake.RandomWorkIdChoose;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 分布式 ID 自动装配，如果配置了spring.data.redis.host就加载LocalRedisWorkIdChoose，否则就加载RandomWorkIdChoose。
 */
@Import(ApplicationContextHolder.class)
public class DistributedIdAutoConfiguration {
    /**
     * 本地 Redis 构建雪花 WorkId 选择器，只有当application.properties或application.yml等配置文件中存在spring.data.redis.host这个
     * 属性时，被该注解标记的 Bean 或者配置类才会被加载和处理
     */
//    @Bean
//    @ConditionalOnProperty("spring.data.redis.host")
//    public LocalRedisWorkIdChoose redisWorkIdChoose() {
//        return new LocalRedisWorkIdChoose();
//    }

    /**
     * 随机数构建雪花 WorkId 选择器。如果项目未使用 Redis，使用该选择器。只有在 Spring 容器中不存在LocalRedisWorkIdChoose类型的 Bean 时，
     * 被这个注解标记的 Bean 或者配置类才会被加载
     */
    @Bean
    @ConditionalOnMissingBean(LocalRedisWorkIdChoose.class)
    public RandomWorkIdChoose randomWorkIdChoose() {
        return new RandomWorkIdChoose();
    }

}
