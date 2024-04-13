package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionToDataBase {
    private String LOGIN = "postgres";
    private String PASSWORD = "1";
    private String URL = "jdbc:postgresql://localhost:5432/the_planet_song";

    public ConnectionToDataBase setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
        return this;
    }
    public ConnectionToDataBase setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
        return this;
    }
    public ConnectionToDataBase setURL(String URL) {
        this.URL = URL;
        return this;
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }

    //-----------------------------
    public void createDataBase(){

    }

    public ResultSet getResultSet(String query) {
        try {
            return createConnection().createStatement().executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getResultUpdate(String query) {
        try {
            return createConnection().createStatement().executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
