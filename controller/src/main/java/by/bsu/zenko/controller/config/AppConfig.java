package by.bsu.zenko.controller.config;

import by.bsu.zenko.controller.Controller;
import by.bsu.zenko.dao.ClubDAO;
import by.bsu.zenko.dao.ClubDAOImpl;
import by.bsu.zenko.dao.PlayerDAO;
import by.bsu.zenko.dao.PlayerDAOImpl;
import by.bsu.zenko.model.Club;
import by.bsu.zenko.model.Player;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import javax.sql.DataSource;
import java.util.Locale;


/**
 * Created by 123 on 14.10.2016.
 */
@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan(value = {"by.bsu.zenko.dao", "by.bsu.zenko.controller", "by.bsu.zenko.model"})
@EnableWebMvc
@EnableTransactionManagement
public class AppConfig {
    @Autowired
    private Environment environment;
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("db.className"));
        dataSource.setUrl(environment.getProperty("db.url"));
        dataSource.setUsername(environment.getProperty("db.username"));
        dataSource.setPassword(environment.getProperty("db.password"));
        return dataSource;
    }
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        Locale.setDefault(Locale.ENGLISH);
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

        sessionBuilder.addAnnotatedClasses(Player.class,Club.class, Controller.class);
        sessionBuilder.setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        return sessionBuilder.buildSessionFactory();
    }
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);
        return transactionManager;
    }
    @Bean
    public PlayerDAO getPlayerDao(SessionFactory sessionFactory) {
        return new PlayerDAOImpl(sessionFactory);
    }
    @Bean
    public ClubDAO getClubDao(SessionFactory sessionFactory) {
        return new ClubDAOImpl(sessionFactory);
    }



}
