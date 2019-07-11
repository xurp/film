package com.geekq.guns.core.log;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 日志管理器
 *
 * @author fengshuonan
 * @date 2017-03-30 16:29
 */
public class LogManager {

    //日志记录操作延时
    private final int OPERATE_DELAY_TIME = 10;

    //异步操作记录日志的线程池
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

    private LogManager() {
    }

    // [注]:这里的LogManager没被spring管理,自己建立了一个静态的LogManager,然后用me()返回
    public static LogManager logManager = new LogManager();

    public static LogManager me() {
        return logManager;
    }

    // [注]:感觉本类LogManager就是搞了一个简单的单例模式,因此也只有一个ScheduledThreadPoolExecutor线程来做log写入
    public void executeLog(TimerTask task) {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }
}
