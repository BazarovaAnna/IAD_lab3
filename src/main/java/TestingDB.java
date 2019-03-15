public class TestingDB {
    public static void main(String[]args) {
        PointsDB.selectAll();
        PointsDB.dropDB();
        PointsDB.createDB();

    }
}
