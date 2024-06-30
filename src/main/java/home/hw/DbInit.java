package home.hw;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.api.configuration.FluentConfiguration;

public class DbInit {
    private static DbInit instance;
    private String connectionUrl;

    private DbInit(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public static DbInit getInstance() {
        if (instance == null) {
            instance = new DbInit(Constant.CONNECTION_URL);
        }
        return instance;
    }

    public void initDB() {
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();
        flyway.migrate();

        Configuration configuration = flyway.getConfiguration();

        // Получение текущих папок с миграциями
        Location[] locations = configuration.getLocations();


        // Вывод текущих папок с миграциями
        System.out.println("Current migration locations:");
        for (Location location : locations) {
            System.out.println(location);
        }
    }

}

