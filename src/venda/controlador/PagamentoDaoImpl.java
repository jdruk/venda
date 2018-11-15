package venda.controlador;

import java.util.ArrayList;
import venda.modelo.Cliente;
import venda.modelo.Pagamento;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import venda.utilitario.FabricaConexao;

public class PagamentoDaoImpl implements PagamentoDao{

    @Override
    public void criar(Pagamento pagamento) {
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("insert into pagamento"
                    + " (codigo, venda_id, valor, data_pagamento, pago ) values (null, ?, ?, ?, ?);");
            stmt.setInt(1, pagamento.getVenda().getCodigo());
            stmt.setBigDecimal(2, pagamento.getValor());
            stmt.setDate(3, new java.sql.Date(pagamento.getDataPagamento().getTime()));
            stmt.setBoolean(4, pagamento.isPago());
            stmt.execute();
            stmt.close();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(Pagamento pagamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Pagamento pagamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pagamento buscar(Pagamento pagamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pagamento> todas(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
