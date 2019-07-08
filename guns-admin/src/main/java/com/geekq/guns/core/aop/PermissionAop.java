/**
 * Copyright (c) 2015-2017, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.geekq.guns.core.aop;

import com.geekq.guns.core.common.annotion.Permission;
import com.geekq.guns.core.common.constant.Const;
import com.geekq.guns.core.shiro.check.PermissionCheckManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.naming.NoPermissionException;
import java.lang.reflect.Method;

/**
 * AOP 权限自定义检查
 */
// [注]:其实也可以用shiro自带的@RequiresPermissions
@Aspect
@Component
@Order(200)
public class PermissionAop {

    @Pointcut(value = "@annotation(com.geekq.guns.core.common.annotion.Permission)")
    private void cutPermission() {

    }

    @Around("cutPermission()")
    public Object doPermission(ProceedingJoinPoint point) throws Throwable {
        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        Permission permission = method.getAnnotation(Permission.class);
        // [注]:例:@Permission(Const.ADMIN_NAME)
        Object[] permissions = permission.value();
        if (permissions == null || permissions.length == 0) {
            //检查全体角色
        	// [注]:若注解里是空的值,那么直接查permission,大致意思就是每个menu里都有允许访问的permission,逻辑大概是:user-role-menu-permission,然后用注解permission看user能否访问
            boolean result = PermissionCheckManager.checkAll();
            if (result) {
                return point.proceed();
            } else {
                throw new NoPermissionException();
            }
        } else {
            //检查指定角色
        	// [注]:如果注解里有值,查用户有没有这个permission,有的话就能访问
            boolean result = PermissionCheckManager.check(permissions);
            if (result) {
                return point.proceed();
            } else {
                throw new NoPermissionException();
            }
        }

    }

}
