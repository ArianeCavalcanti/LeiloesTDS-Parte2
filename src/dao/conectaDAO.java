package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Ariane
 * @version 1.0
 * @since Primeira versão
 */
public class conectaDAO {

    // URL do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/uc11?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "T#7aB3$0m2@i";

    // Método para obter a conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        try {
            // Registrar o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Retornar a conexão estabelecida
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Driver JDBC não encontrado.", ex);
        }
    }

    // Método para fechar a conexão
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }

    // Método para preparar uma instrução SQL
    public static PreparedStatement prepareStatement(Connection conn, String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }
}
