package com.taxcalc.config;

import com.taxcalc.dao.TaxDAO;
import com.taxcalc.daoImpl.TaxDAOImpl;
import com.taxcalc.dto.Tax;
import com.taxcalc.sericeImpl.TaxServiceImpl;
import com.taxcalc.service.TaxService;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.orm.hibernate4.HibernateTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by KART on 10.03.2016.
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.taxcalc.controller")
@EnableTransactionManagement
//@ComponentScan(basePackageClasses = MainController.class)
//@PropertySource("file:/etc/elizz.properties")
public class AppConfig  extends WebMvcConfigurerAdapter {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public TaxDAO getTaxDAO(){
        return new TaxDAOImpl();
    }

    @Bean
    public TaxService getTaxService(){
        return new TaxServiceImpl();
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost/postgres/");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        return dataSource;
    }

    //@Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(getHibernateProperties());
        sessionBuilder.addAnnotatedClasses(Tax.class);
        return sessionBuilder.buildSessionFactory();
    }

    //@Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);

        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }


//    @Bean
//    public HibernateTransactionManager getTransactionManager(){
//        return new HibernateTransactionManager();
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry
    ) {
        registry.addResourceHandler("resources/**").addResourceLocations("resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer
    ) {
        configurer.enable();
    }


}
