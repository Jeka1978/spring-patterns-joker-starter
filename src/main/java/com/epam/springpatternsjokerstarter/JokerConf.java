package com.epam.springpatternsjokerstarter;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Evgeny Borisov
 */
@Configuration
@Import(LegacyBeanDefinitionRegistrar.class)
public class JokerConf {

    @Bean
    public CoronaControllerAdvice coronaControllerAdvice(){
        return new CoronaControllerAdvice();
    }

    @Bean
    public CustomPointcut customPointcut(){
        return new CustomPointcut();
    }

    @Bean
    public ExceptionHandlerAspect exceptionHandlerAspect(){
        return new ExceptionHandlerAspect();
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        return new DefaultPointcutAdvisor(customPointcut(), exceptionHandlerAspect());
    }











    @Bean
    public InjectListBPP injectListBPP(){
        return new InjectListBPP();
    }
}
