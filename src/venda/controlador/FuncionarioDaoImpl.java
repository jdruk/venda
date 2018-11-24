
package venda.controlador;

import java.util.List;
import venda.modelo.Funcionario;
import venda.utilitario.FabricaConexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDaoImpl implements  FuncionarioDao{

    @Override
    public void criar(Funcionario funcionario) {
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("insert into funcionario values (null,?,?)");
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getQuantidadeFaltas());
            stmt.execute();
            stmt.close();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(Funcionario funcionario) {
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("delete from funcionario where codigo  = ?");
            stmt.setLong(1, funcionario.getCodigo());
            stmt.execute();
            stmt.close();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Funcionario buscar(int codigo) {
        Funcionario funcionario = null;
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("select * from funcionario where codigo  = ?");
            stmt.setLong(1, codigo);
            funcionario = carregarFuncionario(stmt.executeQuery());
            stmt.close();
            FabricaConexao.fecharConexao();
           
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return funcionario;
    }

    @Override
    public List<Funcionario> todos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("select * from funcionario");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                funcionarios.add(carregarFuncionario(rs));
            }
            
            stmt.close();
            FabricaConexao.fecharConexao();
           
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return funcionarios;
    }
    
    private Funcionario carregarFuncionario(ResultSet rs){
        Funcionario funcionario = null;
        try {
            funcionario = new Funcionario();
            funcionario.setCodigo(rs.getLong("codigo"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setQuantidadeFaltas(rs.getInt("quantidadefaltas"));
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    @Override
    public void atualizar(Funcionario funcionario) {
       try {
            Connection conexao = FabricaConexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("update funcionario set nome = ?, quantidadefaltas = ? where codigo = ?;");
            stmt.setLong(1, funcionario.getCodigo());
            stmt.setString(2, funcionario.getNome());
            stmt.setInt(3, funcionario.getQuantidadeFaltas());
            stmt.execute();
            stmt.close();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
