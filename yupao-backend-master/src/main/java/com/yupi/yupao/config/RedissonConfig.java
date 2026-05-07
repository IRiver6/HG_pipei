package com.yupi.yupao.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Redisson 配置
 * 用于配置 Redisson 客户端，连接 Redis 服务器
 */
@Configuration // 标记为配置类，用于 Spring 容器初始化
@ConfigurationProperties(prefix = "spring.redis") // 绑定配置文件中以 "spring.redis" 开头的属性
@Data // Lombok 注解，自动生成 getter、setter、toString 等方法
public class RedissonConfig {

    private String host; // Redis 服务器主机地址

    private String port; // Redis 服务器端口号



    /**
     * 创建并配置 RedissonClient Bean
     * @return 配置好的 RedissonClient 实例
     */
    @Bean // 标记为 Bean，由 Spring 容器管理
    public RedissonClient redissonClient() {
        // 1. 创建配置
        Config config = new Config();
        // 拼接 Redis 连接地址，格式为 "redis://host:port"
        String redisAddress = String.format("redis://%s:%s", host, port);
        // 配置单服务器模式，设置连接地址和数据库索引
        config.useSingleServer().setAddress(redisAddress).setDatabase(3);
        // 2. 创建实例
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
