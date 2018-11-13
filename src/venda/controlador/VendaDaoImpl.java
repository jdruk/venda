package venda.controlador;

import java.util.ArrayList;
import venda.modelo.Venda;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import venda.modelo.Cliente;
import venda.utilitario.FabricaConexao;

public class VendaDaoImpl implements VendaDao {

    @Override
    public void criar(Venda venda) {
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "insert into venda(codigo,cliente_id,data_venda, tipo, status, desconto) values (null, ?,?,?,?,?) ";
            PreparedStatement stmt = conexao.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, venda.getCliente().getCodigo());
            stmt.setDate(2, new java.sql.Date(venda.getData().getTime()));
            stmt.setInt(3, venda.getTipo());
            stmt.setInt(4, venda.getStatus());
            stmt.setBigDecimal(5, venda.getDesconto());
            stmt.executeUpdate();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(Venda venda) {
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "delete from venda where codigo = ? ";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, venda.getCodigo());
            stmt.executeUpdate();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Venda venda) {
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "update venda set cliente_id = ? , tipo = ? , status = ?, desconto = ? where codigo = ? ";
            PreparedStatement stmt = conexao.prepareStatement(query,
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, venda.getCliente().getCodigo());
            stmt.setInt(2, venda.getTipo());
            stmt.setInt(3, venda.getStatus());
            stmt.setBigDecimal(4, venda.getDesconto());
            stmt.setInt(5, venda.getCodigo());
            stmt.executeUpdate();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Venda buscar(int codigo) {
        Venda venda = null;
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "select * from venda where codigo = ?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            FabricaConexao.fecharConexao();
            if (rs.next()) {
                venda = carregarVenda(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }

    @Override
    public ArrayList<Venda> todas() {
        ArrayList<Venda> vendas = new ArrayList<>();
        try {
            ResultSet rs = selecionarVendas("select * from venda");
            while (rs.next()) {
                vendas.add(carregarVenda(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

    private ResultSet selecionarVendas(String query) {
        ResultSet rs = null;
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(query);
            rs = stmt.executeQuery();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    private Venda carregarVenda(ResultSet rs) {
        Venda venda = null;
        try {
            venda = new Venda();
            venda.setCodigo(Integer.parseInt(rs.getString("codigo")));
            Cliente cliente = new ClienteDaoImpl().buscar(rs.getInt("cliente_id"));
            venda.setCliente(cliente);
            venda.setData(rs.getTimestamp("data_venda"));
            venda.setStatus(rs.getInt("status"));
            venda.setTipo(rs.getInt("tipo"));
            venda.setDesconto(rs.getBigDecimal("desconto"));
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }
}
