package com.zy.log.starter.config;

import com.zy.log.starter.annotation.ILog;
import com.zy.log.starter.core.ILogPrintAspect;
import org.springframework.context.annotation.Bean;

public class LogAutoConfiguration {

    /**
     * {@link ILog} 日志打印 AOP 切面
     */
    @Bean
    public ILogPrintAspect iLogPrintAspect() {
        return new ILogPrintAspect();
    }
}
