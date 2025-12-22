package br.com.renan.crudveiculos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public final class ConnectionFactory {

    private static final String PROPERTIES_FILE = "/db.properties";
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        try (InputStream input = ConnectionFactory.class.getResourceAsStream(PROPERTIES_FILE)) {
            Properties prop = new Properties();
            prop.load(input);
            URL = prop.getProperty("db.url");
            USER = prop.getProperty("db.user");
            PASSWORD = prop.getProperty("db.password");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar configurações do banco de dados", e);
        }
    }

    private ConnectionFactory() {
        // Impedindo instanciação
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
