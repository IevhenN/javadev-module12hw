import home.hw.config.TypeDB;
import home.hw.dao.DbInit;

public class App {
    public static void main(String[] args) {
        new DbInit(TypeDB.PROD.getDbConnectUrl()).initDB();
    }
}
