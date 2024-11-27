package com.zy.pattern.starters.config;

import com.zy.base.starters.ApplicationBaseAutoConfiguration;
//import com.zy.pattern.starters.chain.AbstractChainContext;
//import com.zy.pattern.starters.strategy.AbstractStrategyChoose;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;

@ImportAutoConfiguration(ApplicationBaseAutoConfiguration.class)
public class AutoConfiguration {

    /**
     * 策略模式选择器
     */
//    @Bean
//    public AbstractStrategyChoose abstractStrategyChoose() {
//        return new AbstractStrategyChoose();
//    }

    /**
     * 责任链上下文
     */
//    @Bean
//    public AbstractChainContext abstractChainContext() {
//        return new AbstractChainContext();
//    }
}
