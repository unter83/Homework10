package repository;


import repository.view.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {


        String connectionString = "jdbc:sqlite:products.db";
        String databaseUrl = "jdbc:sqlite:shop.db";
        ConsoleViewImpl ui = new ConsoleViewImpl(connectionString,databaseUrl);
        try {
            ui.run();
        } catch (SQLException e ) {
            System.out.println(e.getSQLState());
        }

    }


}