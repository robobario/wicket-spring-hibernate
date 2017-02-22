package org.example.app;

import com.arjuna.ats.jta.TransactionManager;

import org.example.Service;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
@Configuration
@PropertySource("classpath:/application.properties")
@EnableTransactionManagement
public class Context {

    public static final String PROVIDER = "hibernate.ogm.datastore.provider";

    @Bean
    public LocalEntityManagerFactoryBean factoryBean(Environment env) {
        LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("example");
        Properties properties = new Properties();
        properties.put(PROVIDER, env.getProperty(PROVIDER));
        properties.put("hibernate.transaction.jta.platform", "org.hibernate.service.jta.platform.internal.JBossStandAloneJtaPlatform");
        entityManagerFactoryBean.setJpaProperties(properties);
        return entityManagerFactoryBean;
    }

    @Bean
    public Service service() {
        return new Service();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JtaTransactionManager(TransactionManager.transactionManager());
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationSupport() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

}
