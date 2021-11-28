package com.caesar.boot.base.config;

import com.caesar.boot.base.common.config.BaseSwaggerConfig;
import com.caesar.boot.base.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 *
 * @author caesar
 * @date 2021/11/26
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.caesar.boot.base.modules")
                .title("caesar-boot项目骨架")
                .description("caesar-boot项目骨架相关接口文档")
                .contactName("caesar")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
