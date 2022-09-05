public class Database {
    private Database() {}

    public static Database getInstance() {
        Database database = new Database();
        return database;
    }
}
