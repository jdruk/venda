package venda.controlador;

import java.sql.*;

public abstract class UtilDaoImpl {
    
    protected int ultimoCodigoGerado(int linhasAfetadas, PreparedStatement stmt) throws SQLException {
        if (linhasAfetadas == 0) {
            throw new SQLException("não conseguiu inserir");
        }
        try ( ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        }
        return -1;
    }
    
    private static EstoqueDao estoqueDao;
    
    public static EstoqueDao getInstanciaEstoqueDao(){
        if (estoqueDao== null) {
            estoqueDao = new EstoqueDaoImpl();
        }
        return estoqueDao;
    }
}
