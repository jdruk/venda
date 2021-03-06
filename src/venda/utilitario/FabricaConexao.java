package venda.utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaConexao {

    private static final String DRIVER_MANAGER = "org.hsqldb.jdbcDriver";
    private static Connection conexao = null;

    private static final String USUARIO = "SA";
    private static final String SENHA = "";
    private static final String URL = "jdbc:hsqldb:file:/home/josafams/v2;shutdown=true;hsqldb.write_delay=false;sql.syntax‌​_ora=true;";

    public static Connection conectar() {
        if (conexao == null) {
            try {
                Class.forName(DRIVER_MANAGER);
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexao;
    }

    public static boolean fecharConexao() {
        try {
            conexao.close();
            conexao = null;
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
