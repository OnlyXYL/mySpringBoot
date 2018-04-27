package com.bmsmart.spring.boot.springboot.util;

import com.bmsmart.spring.boot.springboot.annotion.Param;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 日志信息
 *
 * @param
 * @author XiaYaLing
 * @date 2018/4/26
 * @return
 */
@Slf4j
public class LogUtil {

    /**
     * 获取当前方法名
     *
     * @param
     * @return java.lang.String
     * @author XiaYaLing
     * @date 2018/4/26
     */
    public static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[0].getMethodName();
    }

    /**
     * 获取指定方法的参数名
     *
     * @param method 要获取参数名的方法
     * @return 按参数顺序排列的参数名列表
     */
    public static String getMethodParameterNamesByAnnotation(Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (parameterAnnotations == null || parameterAnnotations.length == 0) {
            return null;
        }
        String[] parameterNames = new String[parameterAnnotations.length];
        int i = 0;
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation : parameterAnnotation) {
                if (annotation instanceof Param) {
                    Param param = (Param) annotation;
                    parameterNames[i++] = param.value();
                }
            }
        }
        return Arrays.toString(parameterNames);
    }
}
