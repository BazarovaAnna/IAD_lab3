import java.sql.*;

public class PointsDB {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void createDB(){
        Connection c;
        Statement stmt;

        try {
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/","postgres", "POIUYtrewq12345");
        c.setAutoCommit(false);
        System.out.println("-- Opened database for CREATE successfully");
        String sql;

        //-------------- CREATE TABLE ---------------

        try{
            stmt = c.createStatement();
            sql = "CREATE TABLE Points " +
                    "(ID bigserial PRIMARY KEY     NOT NULL," +
                    " Xvalue           TEXT    NOT NULL, " +
                    " Yvalue           TEXT     NOT NULL, " +
                    " Rvalue        TEXT NOT NULL, " +
                    " Match         TEXT NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("-- Table created successfully");
        }catch(Exception e){
            System.out.println("-- Table already exists, drop and recreate");
            dropDB();
            createDB();
        }

        c.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }
    public static void dropDB(){
        Connection c;
        Statement stmt;

        try {
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/","postgres", "POIUYtrewq12345");
            c.setAutoCommit(false);
            System.out.println("-- Opened database for DROP successfully");
            String sql;
            //-------------- DELETE TABLE ----------------------
            stmt = c.createStatement();
            sql = "DROP TABLE Points;";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            System.out.println("-- Operation DROP done successfully");
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    public static void add(Point p){
        Connection c;
        Statement stmt;

        try {
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/","postgres", "POIUYtrewq12345");
            c.setAutoCommit(false);
            System.out.println("-- Opened database for ADD successfully");
            String sql;

            //--------------- INSERT ROWS ---------------
            stmt = c.createStatement();
            sql = "INSERT INTO Points (Xvalue,Yvalue,Rvalue,Match) VALUES ('"+p.getX()+"','"+p.getY()+"','"+p.getR()+"','"+p.getHit()+"');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            System.out.println("-- Records created successfully");
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
    public static void selectAll(){

        Connection c;
        Statement stmt;

        try {
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/","postgres", "POIUYtrewq12345");
            c.setAutoCommit(false);
            System.out.println("-- Opened database for SELECT successfully");
            String sql;

        //--------------- SELECT DATA ------------------
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM Points;" );
        while ( rs.next() ) {
            int id = rs.getInt("ID");
            String x = rs.getString("Xvalue");
            String y = rs.getString("Yvalue");
            String r = rs.getString("Rvalue");
            String hit = rs.getString("Match");
            System.out.println(String.format("ID=%s X=%s Y=%s R=%s Hit=%s",id,x,y,r,hit));
        }
        rs.close();
        stmt.close();
        c.commit();
        System.out.println("-- Operation SELECT done successfully");

        c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
