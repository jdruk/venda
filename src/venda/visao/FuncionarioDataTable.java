/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.visao;

import java.util.List;
import javax.swing.JOptionPane;
import venda.controlador.FuncionarioDao;
import venda.controlador.FuncionarioDaoImpl;
import venda.modelo.Funcionario;

/**
 *
 * @author josafams
 */
public class FuncionarioDataTable extends TableModel{

    private FuncionarioDao funcionarioDao = new FuncionarioDaoImpl();
    private List<Funcionario> funcionarios = funcionarioDao.todos();
    
    public FuncionarioDataTable(){
        colunas = new String[]{"Nome", "Quantidade de faltas"};
    }
    
    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
       switch(coluna){
           case 0:
               return funcionarios.get(linha).getNome();
            case 1:
               return funcionarios.get(linha).getQuantidadeFaltas();
       }
        
        return null;
    }
    
    void addFuncionario(){
       String nome = JOptionPane.showInputDialog(null, "Nome");
       Funcionario funcionario = new Funcionario();
       funcionario.setNome(nome);
       funcionario.setQuantidadeFaltas(0);
       
       new FuncionarioDaoImpl().criar(funcionario);
       funcionarios = funcionarioDao.todos();
       
       this.fireTableDataChanged();
    }
    
    Funcionario pegarFuncionario(int linha){
        return funcionarios.get(linha);
    }
    
}
