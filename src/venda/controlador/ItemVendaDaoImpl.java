package venda.controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import venda.modelo.ItemVenda;
import java.sql.*;
import java.util.ArrayList;
import venda.modelo.Venda;
import venda.utilitario.FabricaConexao;
import venda.utilitario.QuantidadeException;

public class ItemVendaDaoImpl implements ItemVendaDao {

    private EstoqueDao estoqueDao = new EstoqueDaoImpl();

    @Override
    public void criar(ItemVenda itemVenda) throws QuantidadeException {
        if (estoqueDao.decrementarEstoque(itemVenda.getProduto(), itemVenda.getQuantidade())) {
            try {
                Connection conexao = FabricaConexao.conectar();
                String query = "insert into itemvenda (codigo,venda_id, quantidade, produto_id, valor) values (null, ?,?,?,?) ";
                PreparedStatement stmt = conexao.prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, itemVenda.getVenda().getCodigo());
                stmt.setInt(2, itemVenda.getQuantidade());
                stmt.setInt(3, itemVenda.getProduto().getCodigo());
                stmt.setBigDecimal(4, itemVenda.getValorVenda());
                stmt.executeUpdate();
                FabricaConexao.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            throw  new QuantidadeException();
        }
    }

    @Override
    public void deletar(ItemVenda itemVenda) {
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "delete from itemvenda where codigo = ?";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, itemVenda.getCodigo());
            stmt.executeUpdate();
            FabricaConexao.fecharConexao();
            estoqueDao.acrescentarEstoque(itemVenda.getProduto(), itemVenda.getQuantidade());
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(ItemVenda itemVenda) throws QuantidadeException {
        ItemVenda antigo = buscar(itemVenda.getCodigo());
        estoqueDao.acrescentarEstoque(antigo.getProduto(), antigo.getQuantidade());
        if (estoqueDao.decrementarEstoque(itemVenda.getProduto(), itemVenda.getQuantidade())) {
            try {
                Connection conexao = FabricaConexao.conectar();
                String query = "update itemvenda set venda_id = ?, quantidade =? , produto_id = ?, valor =? where codigo = ? ";
                PreparedStatement stmt = conexao.prepareStatement(query,
                        Statement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, itemVenda.getVenda().getCodigo());
                stmt.setInt(2, itemVenda.getQuantidade());
                stmt.setInt(3, itemVenda.getProduto().getCodigo());
                stmt.setBigDecimal(4, itemVenda.getValorVenda());
                stmt.setInt(5, itemVenda.getCodigo());
                stmt.executeUpdate();
                FabricaConexao.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            estoqueDao.decrementarEstoque(antigo.getProduto(), antigo.getQuantidade());
            throw new QuantidadeException();
        }

    }

    @Override
    public ItemVenda buscar(int codigo) {
        ItemVenda item = null;
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("select * from itemvenda where codigo = ?");
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                item = carregarItemVenda(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    @Override
    public List<ItemVenda> todos(Venda venda) {
        ArrayList<ItemVenda> itens = new ArrayList<>();
        try {
            ResultSet rs = selecionarItens(venda);
            while (rs.next()) {
                itens.add(carregarItemVenda(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itens;
    }

    private ItemVenda carregarItemVenda(ResultSet rs) {
        ItemVenda item = null;
        try {
            item = new ItemVenda();
            item.setCodigo(rs.getInt("codigo"));
            item.setQuantidade(rs.getInt("quantidade"));
            item.setValorVenda(rs.getBigDecimal("valor"));
            item.setVenda(new VendaDaoImpl().buscar(rs.getInt("venda_id")));
            item.setProduto(new ProdutoDaoImpl().buscar(rs.getInt("produto_id")));
        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    private ResultSet selecionarItens(Venda venda) {
        ResultSet rs = null;
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "select * from itemvenda where venda_id =? ";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, venda.getCodigo());
            rs = stmt.executeQuery();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

}
