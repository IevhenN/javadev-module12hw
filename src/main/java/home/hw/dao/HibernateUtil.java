package home.hw.dao;

import home.hw.config.Constant;
import home.hw.entity.Client;
import home.hw.entity.Planet;
import home.hw.entity.Ticket;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static HibernateUtil INSTANCE;
    @Getter
    private SessionFactory sessionFactory;
    @Getter
    private SessionFactory testSessionFactory;

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .configure("hibernate-prod.properties")
                .setProperty("hibernate.connection.url", Constant.DB_URL)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
        testSessionFactory = new Configuration()
                .configure("hibernate-test.properties")
                .setProperty("hibernate.connection.url", Constant.TEST_DB_URL)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HibernateUtil();
        }
        return INSTANCE;
    }

}
