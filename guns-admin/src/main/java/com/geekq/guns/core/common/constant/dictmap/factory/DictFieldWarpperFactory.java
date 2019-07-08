package com.geekq.guns.core.common.constant.dictmap.factory;

import com.geekq.guns.core.common.constant.factory.ConstantFactory;
import com.geekq.guns.core.common.constant.factory.IConstantFactory;
import com.geekq.guns.core.common.exception.BizExceptionEnum;
import com.geekq.guns.core.exception.GunsException;
import com.geekq.guns.core.util.SpringContextHolder;

import java.lang.reflect.Method;

/**
 * 字典字段的包装器(从ConstantFactory中获取包装值)
 *
 * @author fengshuonan
 * @date 2017-05-06 15:12
 */
public class DictFieldWarpperFactory {

    public static Object createFieldWarpper(Object parameter, String methodName) {
    	// [注]:这里没有用注入的方式,直接用了SpringContextHolder.getBean
        IConstantFactory constantFactory = ConstantFactory.me();
        try {
        	// 这个方法大概的意思是:dictmap里存了些方法名,用这个方法实现methodName(parameter)
            Method method = IConstantFactory.class.getMethod(methodName, parameter.getClass());
            return method.invoke(constantFactory, parameter);
        } catch (Exception e) {
            try {
                Method method = IConstantFactory.class.getMethod(methodName, Integer.class);
                return method.invoke(constantFactory, Integer.parseInt(parameter.toString()));
            } catch (Exception e1) {
                throw new GunsException(BizExceptionEnum.ERROR_WRAPPER_FIELD);
            }
        }
    }

}
