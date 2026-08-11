package revision.singleton;


public class DbConnection {
    private DbConnection() {
        System.out.println("Singleton constructor inilialized!");
    }

    private static DbConnection conObject;

    private static volatile DbConnection conObject2;

    private static DbConnection instance = new DbConnection();

    public static DbConnection getInstance() {
        return instance;
    }

    // lazy
    public static DbConnection getInstance2() {
        if (instance == null) {
            return instance;
        }
        return instance;
    }

    synchronized public static DbConnection getInstance3() {
        if (instance == null) {
            conObject = new DbConnection();
        }
        return instance;
    }

    // double locking
    public static DbConnection getInstance4() {
        if (conObject2 == null) {
            synchronized (DbConnection.class) {
                if (conObject2 == null) {
                    conObject2 = new DbConnection();
                }
            }
        }
        return conObject2;
    }


    public static void main(String[] args) {
        DbConnection dbConnection = DbConnection.getInstance2();
    }
}
