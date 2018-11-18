package venda.controlador;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import venda.modelo.Estoque;
import venda.modelo.Produto;
import venda.utilitario.FabricaConexao;
import venda.utilitario.QuantidadeException;

public class EstoqueDaoImpl implements EstoqueDao{

    @Override
    public void criar(Estoque estoque) {
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("insert into estoque(codigo, produto_id, quantidade) values (null, ?,?) ");
            stmt.setInt(1, estoque.getProduto().getCodigo());
            stmt.setInt(2, estoque.getQuantidade());
            stmt.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void deletar(Estoque estoque) {
        if(estoque == null || estoque.getCodigo() == 0) {
            System.out.println();
        } else {
            try {
                Connection conexao = FabricaConexao.conectar();
                PreparedStatement stmt = conexao.prepareStatement("delete from estoque where codigo = ?  ");
                stmt.setInt(1, estoque.getCodigo());
                stmt.execute();
                FabricaConexao.fecharConexao();
            } catch (SQLException ex) {
                Logger.getLogger(EstoqueDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void atualizar(Estoque estoque) {
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("update estoque set produto_id= ?, quantidade = ? where codigo = ?");
            stmt.setInt(1, estoque.getProduto().getCodigo());
            stmt.setInt(2, estoque.getQuantidade());
            stmt.setInt(3, estoque.getCodigo());
            stmt.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Estoque buscar(int codigo) {
        return buscar("select * from estoque where codigo = ?",codigo);
    }
    
    public Estoque buscar(Produto produto){
        if(produto == null || produto.getCodigo() == null){
            throw new IllegalArgumentException("Produto não pode ser null");
        }
        return buscar("select * from estoque where produto_id = ?",produto.getCodigo());
    }
    
    private Estoque buscar(String query, int codigo){
        Estoque estoque = null;
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            FabricaConexao.fecharConexao();
            if(rs.next())
                estoque = carregarEstoque(rs);
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estoque;
    }

    @Override
    public List<Estoque> todos() {
        return obterEstoque("select * from estoque ");
    }

    private Estoque carregarEstoque(ResultSet rs) {
        Estoque estoque = new Estoque();
        try {
            estoque.setCodigo(Integer.parseInt(rs.getString("codigo")));
            estoque.setProduto(new ProdutoDaoImpl().buscar(Integer.parseInt(rs.getString("produto_id"))));
            estoque.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estoque;
    }

    @Override
    public List<Estoque> disponiveis() {
        return obterEstoque("select * from estoque where quantidade > 0");
    }
    
    private List<Estoque> obterEstoque(String query){
        ArrayList<Estoque> estoques = new ArrayList<>();
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            FabricaConexao.fecharConexao();
            while(rs.next())
                estoques.add(carregarEstoque(rs));
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estoques;  
    }

    @Override
    public void acrescentarEstoque(Produto produto, int quantidade) {
        Estoque estoque = buscar(produto);
        estoque.setQuantidade(estoque.getQuantidade() + quantidade);
        atualizar(estoque);
    }

    @Override
    public boolean decrementarEstoque(Produto produto, int quantidade) {
        Estoque estoque = buscar(produto);
        if(estoque.getQuantidade()< quantidade){
            return false;
        }
        estoque.setQuantidade(estoque.getQuantidade() - quantidade);
        atualizar(estoque);
        
        return true;
    }
    
    
}
