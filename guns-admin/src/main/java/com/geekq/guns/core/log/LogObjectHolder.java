package com.geekq.guns.core.log;

import com.geekq.guns.core.util.SpringContextHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

/**
 * 被修改的bean临时存放的地方
 *
 * @author fengshuonan
 * @date 2017-03-31 11:19
 */
// [注]:本类的使用方式一般是LogObjectHolder.me().get()和LogObjectHolder.me().set(***),主要就是保存获取object,至于为什么要这么做而不是直接操作LogObjectHolder的object
// [注]:可能涉及spring的scope.默认是单例的,也可以是request(每个HTTP请求对应一个bean)和session的(每个session对应一个bean).一般来说当然后者存活时间更长
// [注]:比如本类在LogAop使用,该类是单例的,那么本类没法直接autowired进去,因为单例的bean是直接生成的,本类一个session一个bean,没办法再次注入单例了.
// [注]:所以这里的me()其实就是封装了一个获取bean(即本类)的方法而已,这是我的理解
@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION)
public class LogObjectHolder implements Serializable{

    private Object object = null;

    public void set(Object obj) {
        this.object = obj;
    }

    public Object get() {
        return object;
    }

    // [注]:util包里用autowired注入时,由于是static方法,方法里的对象也要是static的,所以不能注入.SpringContextHolder可以获得静态的对象
    // [注]:注意SpringContextHolder这个类是自己写的,不过非常通用
    public static LogObjectHolder me(){
        LogObjectHolder bean = SpringContextHolder.getBean(LogObjectHolder.class);
        return bean;
    }
}
