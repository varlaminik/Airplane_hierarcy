package airplane_hierarcy.db;

import java.sql.*;

public class DBworker {

    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static String DB_URL;// = "jdbc:mysql://10.0.0.10:3306/aircraftdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static String INSERT_NEW;// = "INSERT INTO aircraft VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static String GET;// = "SELECT * FROM aircraft";
    public static String DELETE;
    public static String SELECT;
    public static String UPDATE;


    static String USER;// = "jojo";
    static String PASS;// = "jojo";
    public Connection connection = null;


    public DBworker() {

        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();

        }

        System.out.println("MySQL JDBC Driver Registered!");

    }

    public DBworker(String db_url, String user, String pass) {

        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();

        }

        System.out.println("MySQL JDBC Driver Registered!");
        DB_URL = db_url;
        USER = user;
        PASS = pass;


    }

    public Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        return connection;
    }

    public Connection getConnection(String DB_URL, String USER, String PASS) {
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        return connection;
    }

    public void Add(Connection con, String table, int id, double weight, double width, double height, int hz, int mp, double ft, String model, double bv, int vs, int sn) throws SQLException {
        INSERT_NEW = "INSERT INTO " + table + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(DBworker.INSERT_NEW);

        preparedStatement.setInt(1, id);
        preparedStatement.setDouble(2, weight);
        preparedStatement.setDouble(3, width);
        preparedStatement.setDouble(4, height);
        preparedStatement.setInt(5, hz);
        preparedStatement.setInt(6, mp);
        preparedStatement.setDouble(7, ft);
        preparedStatement.setString(8, model);
        preparedStatement.setDouble(9, bv);
        preparedStatement.setInt(10, vs);
        preparedStatement.setInt(11, sn);
        preparedStatement.execute();


    }

    public void Delete(Connection con, String table) {
        DELETE = "DELETE * from " + table;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(DBworker.DELETE);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Delete(Connection con, String table, int id) {
        DELETE = "DELETE from " + table + " WHERE " + table + "_id = " + id;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(DBworker.DELETE);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet Seek(Connection con, String table, String title) {
        GET = "SELECT * FROM " + table + " WHERE title = '" + title + "'";
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(DBworker.GET);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultSet;
    }

    public ResultSet Seek(Connection con, String table, int id) {
        GET = "SELECT * FROM " + table + " WHERE " + table + "_id = " + id;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(DBworker.GET);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static ResultSet Seek(Connection con, String table) {
        GET = "SELECT * FROM " + table;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(DBworker.GET);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

   /* public void ShowOut(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println("id: " + id);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }*/

    public static void ShowOut(ResultSet resultSet) throws SQLException {
        int columns = 0;
        try {
            columns = resultSet.getMetaData().getColumnCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
            System.out.println();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void Update(Connection con, String table, int id, String column, String value) {
        UPDATE = "UPDATE " +table+ " SET " +column+ " = '" +value+"' WHERE " + table + "_id = " + id;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(DBworker.UPDATE);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
