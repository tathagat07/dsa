package dev.Singleton;

public class DatabaseConnection {
    //bill pugh solution
    private DatabaseConnection() {
        System.out.println("Bill pugh singleton solution");
    };

    private static class DbConnectionHolder {
        private static DatabaseConnection instance = new DatabaseConnection();
    }

    public static DatabaseConnection getInstance() {
        return DbConnectionHolder.instance;
    }
}
