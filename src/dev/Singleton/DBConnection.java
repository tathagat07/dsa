package dev.Singleton;

public class DBConnection {

    // eager initialization

    private DBConnection() {
        System.out.println("Singleton example constructor");
    }

    private static DBConnection instance = new DBConnection();

    private  static DBConnection conObject;

    private static volatile DBConnection conObject2;

    public static DBConnection getInstance() {
        return instance;
    }
    // lazy initialiazation
    public static DBConnection getInstance2() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    // Synchronized
    synchronized public DBConnection getInstance3() {
        if (instance == null) {
            conObject = new DBConnection();
        }
        return instance;
    }

    // Double locking
    public static DBConnection getInstance4(){
        if (conObject2 == null) {
            synchronized (DBConnection.class){
                if (conObject2 == null) {
                    conObject2 = new DBConnection();
                }
            }
        }
        return conObject2;
    }

}
