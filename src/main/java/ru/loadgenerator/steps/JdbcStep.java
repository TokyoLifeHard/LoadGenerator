package ru.loadgenerator.steps;

import ru.loadgenerator.credentials.DataBaseCredentials;

import java.sql.*;

public class JdbcStep extends Step implements Runnable{
    DataBaseCredentials dataBaseCredentials;

    public JdbcStep(DataBaseCredentials dataBaseCredentials) {
        this.dataBaseCredentials = dataBaseCredentials;
    }

    @Override
    public void execute() {
        ResultSet rs = executeQuery();
        System.out.println(rs.toString());
        try {
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        execute();
    }

    private Connection createConnecton() throws SQLException {
        return DriverManager.getConnection(this.dataBaseCredentials.getDataBaseName(),
                this.dataBaseCredentials.getUser(),
                this.dataBaseCredentials.getPassword());
    }

    private ResultSet executeQuery(){
        ResultSet rs = null;

        try (Connection con = createConnecton()) {
            PreparedStatement ps = con.prepareStatement(this.dataBaseCredentials.getQuery());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public String toString() {
        return "JdbcStep{" +
                "dataBaseCredentials=" + dataBaseCredentials +
                '}';
    }
}
