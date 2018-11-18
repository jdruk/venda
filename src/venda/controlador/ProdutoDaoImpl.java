package venda.controlador;

import java.math.BigDecimal;
import java.util.List;
import venda.modelo.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import venda.modelo.Estoque;
import venda.utilitario.FabricaConexao;

public class ProdutoDaoImpl extends  UtilDaoImpl implements ProdutoDao {


    @Override
    public void criar(Produto produto) {
        inserir(produto);
    }

    private Produto inserir(Produto produto){
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("insert into produto(codigo, nome, valor) values (null,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, produto.getNome());
            stmt.setBigDecimal(2, produto.getValor());
            Integer codigo = ultimoCodigoGerado(stmt.executeUpdate(), stmt);
            produto.setCodigo(codigo);
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
    
    
    @Override
    public void deletar(Produto produto) {
        if (produto == null || produto.getCodigo() == null) {
            throw new IllegalArgumentException("Produto ou código nulo");
        }
        try {
            EstoqueDao estoqueDao = new EstoqueDaoImpl();
            Estoque estoque = estoqueDao.buscar(produto);
            estoqueDao.deletar(estoque);
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("delete from produto  where codigo = ?");
            stmt.setInt(1, produto.getCodigo());
            stmt.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Produto produto) {
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("update produto set nome= ?, valor = ? where codigo = ?");
            stmt.setString(1, produto.getNome());
            stmt.setBigDecimal(2, produto.getValor());
            stmt.setInt(3, produto.getCodigo());
            stmt.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Produto buscar(Integer codigo) {
        Produto produto = null;
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("select * from produto where codigo = ?");
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                produto = carregarProduto(rs);
            }
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produto;
    }

    private Produto carregarProduto(ResultSet rs) {
        Produto produto = null;
        try {
            produto = new Produto();
            produto.setCodigo(Integer.parseInt(rs.getString("codigo")));
            produto.setNome(rs.getString("nome"));
            produto.setValor(new BigDecimal(rs.getString("valor")));

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    @Override
    public List<Produto> todos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            ResultSet rs = todosProdutos();
            while (rs.next()) {
                produtos.add(carregarProduto(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

    private ResultSet todosProdutos() {
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("select * from produto");
            ResultSet rs = stmt.executeQuery();
            FabricaConexao.fecharConexao();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void criar(Estoque estoque) {
        Produto produto = inserir(estoque.getProduto());
        estoque.setProduto(produto);
        new EstoqueDaoImpl().criar(estoque);
    }

    @Override
    public void atualizar(Estoque estoque) {
        this.atualizar(estoque.getProduto());
        new EstoqueDaoImpl().atualizar(estoque);
    }

}
