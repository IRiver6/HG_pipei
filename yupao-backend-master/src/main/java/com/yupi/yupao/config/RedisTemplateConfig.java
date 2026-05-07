package com.yupi.yupao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * RedisTemplate 配置
 * 用于配置Spring Data Redis中的RedisTemplate Bean
 */
@Configuration
public class RedisTemplateConfig {

    /**
     * 创建并配置RedisTemplate Bean
     * @param connectionFactory Redis连接工厂，用于创建Redis连接
     * @return 配置好的RedisTemplate实例，用于Redis操作
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        // 创建RedisTemplate实例
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 设置Redis连接工厂
        redisTemplate.setConnectionFactory(connectionFactory);
        // 设置键序列化器为字符串序列化器
        redisTemplate.setKeySerializer(RedisSerializer.string());
        // 返回配置好的RedisTemplate实例
        return redisTemplate;
    }
}
