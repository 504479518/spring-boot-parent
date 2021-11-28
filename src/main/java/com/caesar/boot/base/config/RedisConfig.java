package com.caesar.boot.base.config;

import com.caesar.boot.base.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置类
 *
 * @author caesar
 * @date 2021/11/2
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}
