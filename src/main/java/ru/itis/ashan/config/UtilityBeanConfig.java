package ru.itis.ashan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class UtilityBeanConfig {
    @Bean
    public ExecutorService executorService(){
        return Executors.newFixedThreadPool(2);
    }
    @Bean("mailTemplateFreeMarkerConfigurationFactory")
    public FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean(){
        FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean = new FreeMarkerConfigurationFactoryBean();
        freeMarkerConfigurationFactoryBean.setTemplateLoaderPath("classpath:/templates/mail");
        return freeMarkerConfigurationFactoryBean;
    }
}
