package venda.controlador;

import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import venda.modelo.Cliente;
import venda.utilitario.FabricaConexao;

public class ClienteDaoImpl extends UtilDaoImpl implements ClienteDao {

    static final int ID_CLIENTE_PADRAO = 0;
    
    public static Cliente getClientePadrao() {
        return new ClienteDaoImpl().buscar(ID_CLIENTE_PADRAO);
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
            cliente.setCodigo(ultimoCodigoGerado(stmt.executeUpdate(), stmt));
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
            EnderecoDao enderecoDao = new EnderecoDaoImpl();
            enderecoDao.deletar(cliente.getEndereco());

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
            String query = "update cliente set nome = ? , rg = ? , planodefidelidade =? where codigo = ? ";
            PreparedStatement stmt = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getRg());
            stmt.setBoolean(3, cliente.isPlanoDeFidelidade());
            stmt.setInt(4, cliente.getCodigo());
            stmt.execute();
            FabricaConexao.fecharConexao();
            new EnderecoDaoImpl().atualizar(cliente.getEndereco());
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
            if (rs.next()) {
                cliente = carregarCliente(rs);
            }
            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> todos() {
        ArrayList<Cliente> clientes = null;
        try {
            Connection conexao = FabricaConexao.conectar();
            String query = "select * from cliente order by nome";
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            clientes = new ArrayList<>();
            while (rs.next()) {
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
