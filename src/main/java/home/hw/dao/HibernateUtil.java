package home.hw.dao;

import home.hw.entity.Client;
import home.hw.entity.Planet;
import home.hw.entity.Ticket;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @Getter
    private SessionFactory sessionFactory;

    public HibernateUtil(String connectionUrl){
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

}
