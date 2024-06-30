package home.hw.dao;

import home.hw.config.Constant;
import org.flywaydb.core.Flyway;

public class DbInit {
    private String connectionUrl;

    public DbInit(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public void initDB() {
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, null, null)
                .load();
        flyway.migrate();
    }

}

