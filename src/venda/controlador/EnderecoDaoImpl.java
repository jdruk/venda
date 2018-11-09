package venda.controlador;

<<<<<<< HEAD
import com.sun.jdi.connect.Connector;
=======
>>>>>>> origin/master
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import venda.modelo.Cliente;
import venda.modelo.Endereco;
import venda.utilitario.FabricaConexao;

public class EnderecoDaoImpl implements EnderecoDao {

    @Override
    public void criar(Endereco endereco) {
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("insert into endereco (codigo, rua, bairro, estado, cliente_id ) values (null, ?, ?, ?, ?);");
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getBairro());
            stmt.setString(3, endereco.getEstado());
            stmt.setInt(4, endereco.getCliente().getCodigo());
            stmt.execute();
            stmt.close();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(Endereco endereco) {
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("delete from endereco where codigo=?");
            stmt.setInt(1, endereco.getCodigo());
            stmt.executeUpdate();
            stmt.close();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(Endereco endereco) {
<<<<<<< HEAD
        if (endereco == null){
            throw new IllegalArgumentException("Endereco não pode ser null");
        }
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("update endereco set rua = ?, bairro = ?, estado = ? where codigo = ?");
=======
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("update endereco set rua = ?, bairro = ?, estado = ? where codigo = ?;");
>>>>>>> origin/master
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getBairro());
            stmt.setString(3, endereco.getEstado());
            stmt.setInt(4, endereco.getCodigo());
            stmt.executeUpdate();
            stmt.close();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Endereco buscar(Cliente cliente) {
        Endereco endereco = null;
        if(cliente.getCodigo() != null){
            try {    
                ResultSet rs = buscar(cliente.getCodigo());
<<<<<<< HEAD
                if (rs.next()) {
=======
                if (rs.first()) {
>>>>>>> origin/master
                    int codigo = Integer.parseInt(rs.getString("codigo"));
                    String rua = rs.getString("rua"), bairro = rs.getString("bairro"), estado = rs.getString("estado");
                    endereco = new Endereco(codigo, rua, bairro, estado, cliente);
                    return endereco;
                }
                return endereco;
            } catch (SQLException ex) {
                Logger.getLogger(EnderecoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return endereco;
    }

    private ResultSet buscar(int cliente) {
        Connection conexao = FabricaConexao.conectar();
        ResultSet rs = null;
<<<<<<< HEAD
        try {
            PreparedStatement stmt = conexao.prepareStatement("select * from endereco where cliente_id = ? ");
=======
        try ( PreparedStatement stmt = conexao.prepareStatement("select endereco where cliente_id = ?")) {
>>>>>>> origin/master
            stmt.setInt(1, cliente);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        FabricaConexao.fecharConexao();
        return rs;
    }

}
