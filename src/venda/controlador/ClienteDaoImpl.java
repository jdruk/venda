package venda.controlador;

import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import venda.modelo.Cliente;
import venda.utilitario.FabricaConexao;

public class ClienteDaoImpl implements ClienteDao {

    private int ultimoCodeGerado(int linhasAfetadas, PreparedStatement stmt) throws SQLException {
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

    @Override
    public void criar(Cliente cliente) {
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "insert into cliente(codigo, nome, rg, planodefidelidade) values (null, ?, ?, ?) ";
            PreparedStatement stmt = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getRg());
            stmt.setBoolean(3, cliente.isPlanoDeFidelidade());
            cliente.setCodigo(ultimoCodeGerado(stmt.executeUpdate(), stmt));
            FabricaConexao.fecharConexao();

            // endereco
            EnderecoDao enderecoDao = new EnderecoDaoImpl();
            cliente.getEndereco().setCliente(cliente);
            enderecoDao.criar(cliente.getEndereco());

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(Cliente cliente) {
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "delete from cliente where codigo = ? ";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, cliente.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Cliente cliente) {
        try {
            Connection conexao = FabricaConexao.conectar();
<<<<<<< HEAD
            String query = "update cliente set nome = ? , rg = ? , planodefidelidade =? where codigo = ? ";
            PreparedStatement stmt = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getRg());
            stmt.setBoolean(3, cliente.isPlanoDeFidelidade());
            stmt.setInt(4, cliente.getCodigo());
            stmt.execute();
=======
            String query = "update cliente nome = ? , rg = ? , planodefidelidade =? where codigo = ? ";
            PreparedStatement stmt = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getRg());
            stmt.setBoolean(3, cliente.isPlanoDeFidelidade());
            stmt.setInt(4, cliente.getCodigo());
>>>>>>> origin/master
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente buscar(int codigo) {
        Cliente cliente = null;
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "select * from cliente where codigo = ? ";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
<<<<<<< HEAD
            if (rs.next()) {
=======
            if (rs.first()) {
>>>>>>> origin/master
                cliente = carregarCliente(rs);
            }
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> todas() {
<<<<<<< HEAD
        ArrayList<Cliente> clientes = null;
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "select * from cliente ";
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            clientes = new ArrayList<>();
=======
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "select * from cliente ";
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
>>>>>>> origin/master
            while(rs.next()){
                clientes.add(carregarCliente(rs));
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientes;
    }

    private Cliente carregarCliente(ResultSet rs) {
        Cliente cliente = null;
        try {
            cliente = new Cliente();
            cliente.setCodigo(Integer.parseInt(rs.getString("codigo")));
            cliente.setNome(rs.getString("nome"));
            cliente.setPlanoDeFidelidade(Boolean.parseBoolean(rs.getString("planodefidelidade")));
            cliente.setRg(rs.getString("rg"));
            EnderecoDao enderecoDao = new EnderecoDaoImpl();
            cliente.setEndereco(enderecoDao.buscar(cliente));
            
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }

}
