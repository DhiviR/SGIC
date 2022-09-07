public class Database {
    private Database() {}

    public static Database getInstance() {
        return new Database();
    }
}
