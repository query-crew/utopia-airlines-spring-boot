package com.smoothstack.connector;


import java.sql.*;



public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/utopia_schema";
    private static final String username = "root";
    private static final String pass = "root";
    private static Connection conn;
    

    public static Connection getConnection() {

        System.out.println("Creating Connection to DB...");

        try {
            conn = DriverManager.getConnection(url, username, pass);
            System.out.println("Connection to database " + url + " is Successful");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection Failed");
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection Failed");
        }
    }

    // Method to handle checking database exists with the table we're using
    public static boolean tableExistsOnConn(String tblName) throws SQLException {
        Connection conn = getConnection();
        DatabaseMetaData dbmd = (DatabaseMetaData) conn.getMetaData();

        ResultSet resultSet = dbmd.getTables(null, null, tblName, new String[] { "TABLE" });
        return resultSet.next();
    }

    // Check the table exists on the connection
    public static boolean tableExists(String tblName) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            return tableExistsOnConn(tblName);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
