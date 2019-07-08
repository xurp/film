package com.geekq.guns.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * spring session配置
 *
 * @author fengshuonan
 * @date 2017-07-13 21:05
 */
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)  //session过期时间(默认就是1800)  如果部署多机环境,需要打开注释
@ConditionalOnProperty(prefix = "guns", name = "spring-session-open", havingValue = "true")
// [注]:@ConditionalOnProperty是读配置文件guns:spring-session-open: false      #是否开启spring session,如果是多机环境需要开启(true/false)
// [注]:这个注解只是说明本注解类是否生效,比如配置文件里改成了true,又用了@EnableRedisHttpSession,那么本类就生效了.
// [注]:springsession:分布式部署经常遇到session共享的问题，要么在nginx代理解决（比如ip hash），要么用spring boot提供的session用redis解决共享的方法。
// [注]:需要在pom加spring-session-data-redis,然后比方说就能在controller里用request.getSession()获取session了.同一个redis让分布式共享"同一个"session域
public class SpringSessionConfig {

}
