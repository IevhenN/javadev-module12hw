package home.hw.app;

import home.hw.config.Constant;
import home.hw.dao.DbInit;
import home.hw.dao.HibernateUtil;
import home.hw.entity.Client;
import home.hw.entity.Planet;
import home.hw.service.ClientCrudService;
import home.hw.service.PlanetCrudService;

public class App {
    public static void main(String[] args) {
        DbInit.initProdDb();

        ClientCrudService clientService = new ClientCrudService(HibernateUtil.getInstance().getSessionFactory());
        System.out.println("clientService.getAll() = " + clientService.getAll());


        PlanetCrudService planetCrudService = new PlanetCrudService(HibernateUtil.getInstance().getSessionFactory());
        System.out.println("planetCrudService.getAll() = " + planetCrudService.getAll());
    }
}
