package org.example.app;

import org.example.Service;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.JPA_JDBC_URL;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;


@Configuration
@PropertySource("classpath:/application.properties")
@EnableTransactionManagement
public class Context {

    @Bean
    public LocalEntityManagerFactoryBean factoryBean(Environment env) {
        LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("example");
        Properties p = new Properties();
        p.setProperty(HBM2DDL_AUTO, env.getProperty(HBM2DDL_AUTO));
        p.setProperty(SHOW_SQL, env.getProperty(SHOW_SQL));
        p.setProperty(DRIVER, env.getProperty(DRIVER));
        p.setProperty(URL, env.getProperty(URL));
        entityManagerFactoryBean.setJpaProperties(p);
        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager txManager(EntityManagerFactory em) {
        return new JpaTransactionManager(em);
    }

    @Bean
    public Service service() {
        return new Service();
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationSupport() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

}
