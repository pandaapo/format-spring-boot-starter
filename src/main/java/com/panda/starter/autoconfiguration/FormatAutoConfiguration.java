package com.panda.starter.autoconfiguration;

import com.panda.starter.format.FormatProcessor;
import com.panda.starter.format.JsonFormatProcessor;
import com.panda.starter.format.StringFormatProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FormatAutoConfiguration {

    @ConditionalOnMissingClass("com.alibaba.fastjson.JSON")
    @Primary
    @Bean
    public FormatProcessor stringFormat() {
        return new StringFormatProcessor();
    }

    @ConditionalOnClass(name = "com.alibaba.fastjson.JSON")
    @Bean
    public FormatProcessor jsonFormat() {
        return new JsonFormatProcessor();
    }
}
