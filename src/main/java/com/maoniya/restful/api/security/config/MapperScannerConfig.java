package com.maoniya.restful.api.security.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * date:  Created in 2018/9/27 17:28
 *
 * @author maoning
 */
@Configuration
@MapperScan(basePackages = "com.maoniya.restful.api.security.dao")
public class MapperScannerConfig {
}
