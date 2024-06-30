import home.hw.config.Constant;
import home.hw.dao.DbInit;

public class App {
    public static void main(String[] args) {
        new DbInit(Constant.DB_URL).initDB();
    }
}
