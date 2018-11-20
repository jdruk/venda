package venda.controlador;

import java.math.BigDecimal;
import java.util.ArrayList;
import venda.modelo.Pagamento;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import venda.modelo.Venda;
import venda.utilitario.FabricaConexao;

public class PagamentoDaoImpl extends UtilDaoImpl implements PagamentoDao {

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
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(Pagamento pagamento) {
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "delete from pagamento where codigo = ?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, pagamento.getCodigo());
            stmt.executeUpdate();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Pagamento pagamento) {
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("update pagamento set pago = ? where codigo = ?");
            stmt.setInt(2, pagamento.getCodigo());
            stmt.setBoolean(1, pagamento.isPago());
            stmt.execute();
            stmt.close();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Pagamento buscar(int codigo) {
        Pagamento pagamento = null;
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("update pagamento set pago = ? where codigo = ?");
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pagamento = carregarPagamento(rs);
            }
            //FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pagamento;
    }

    @Override
    public ArrayList<Pagamento> todas(Venda venda) {
        System.out.println(venda);
        
        ArrayList<Pagamento> pagamentos = new ArrayList<>();
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("select * from pagamento where venda_id = ?");
            stmt.setInt(1, venda.getCodigo());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pagamentos.add(carregarPagamento(rs));
            }
            //FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pagamentos;
    }

    private Pagamento carregarPagamento(ResultSet rs) {
        Pagamento pagamento = null;
        try {
            pagamento = new Pagamento();
            pagamento.setCodigo(rs.getInt("codigo"));
            pagamento.setDataPagamento(rs.getTimestamp("data_pagamento"));
            pagamento.setVenda(new VendaDaoImpl().buscar(rs.getInt("venda_id")));
            pagamento.setValor(rs.getBigDecimal("valor"));
            pagamento.setPago(rs.getBoolean("pago"));
        } catch (SQLException ex) {
            Logger.getLogger(PagamentoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pagamento;
    }

    @Override
    public void deletarTodos(Venda venda) {
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "delete from pagamento where venda_id = ?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, venda.getCodigo());
            stmt.executeUpdate();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void criarParcelas(Venda venda, BigDecimal valor, int quantidade) {
        Pagamento pagamento = new Pagamento();
        pagamento.setVenda(venda);
        pagamento.setValor(valor);
        for (int i = 1; i <= quantidade; i++) {
            Date date = java.sql.Date.valueOf(LocalDate.now().plusMonths(i));
            pagamento.setDataPagamento(date);
            criar(pagamento);
        }
    }

}
