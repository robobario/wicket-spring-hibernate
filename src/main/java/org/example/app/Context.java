package org.example.app;

import org.example.Service;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import javax.sql.DataSource;


@Configuration
@PropertySource("classpath:/application.properties")
@EnableTransactionManagement
public class Context {

    @Bean
    public DataSource dataSource(Environment env) {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(env.getProperty("jdbc.driver.class.name"));
        source.setUrl(env.getProperty("jdbc.url"));
        return source;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(final Environment env, DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setPackagesToScan("org.example.entities");
        Properties p = new Properties();
        p.setProperty(AvailableSettings.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        p.setProperty(AvailableSettings.SHOW_SQL, env.getProperty("hibernate.show_sql"));
        sessionFactoryBean.setHibernateProperties(p);
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager txManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public Service service() {
        return new Service();
    }

}
