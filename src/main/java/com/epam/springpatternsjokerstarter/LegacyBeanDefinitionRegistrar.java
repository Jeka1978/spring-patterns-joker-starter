package com.epam.springpatternsjokerstarter;

import org.reflections.Reflections;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import javax.inject.Singleton;
import java.beans.Introspector;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class LegacyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Reflections scanner = new Reflections("com.naya.corona.legacy");
        Set<Class<?>> classes = scanner.getTypesAnnotatedWith(Singleton.class);
        for (Class<?> aClass : classes) {

            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(aClass);
            beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
            beanDefinition.addQualifier(new AutowireCandidateQualifier(Legacy.class));
            registry.registerBeanDefinition(Introspector.decapitalize(aClass.getSimpleName()),beanDefinition);
        }
    }
}




