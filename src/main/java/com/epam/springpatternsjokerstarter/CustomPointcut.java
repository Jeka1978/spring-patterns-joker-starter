package com.epam.springpatternsjokerstarter;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */

public class CustomPointcut extends DynamicMethodMatcherPointcut {

    private String packagesToHandle="com.epam.springpatternsjoker.corona.psr";

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        return true;
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return aClass.getPackage().getName().contains(packagesToHandle);
            }
        };
    }
}
