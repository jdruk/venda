
package venda.visao;

import java.util.ArrayList;
import venda.controlador.ClienteDaoImpl;
import venda.controlador.ClienteDao;
import javax.swing.table.AbstractTableModel;
import venda.modelo.Cliente;

public class ClienteDataTable extends AbstractTableModel {

    private ClienteDao clienteDao = new ClienteDaoImpl();
    private ArrayList<venda.modelo.Cliente> clientes =  clienteDao.todas();
    private String[] colunas = {"Nome", "Endereço"};
    
    public String getColumnName(int coluna){
        return colunas[coluna];
    }
    
    @Override
    public int getRowCount() {
       return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
           case 0:
               return clientes.get(linha).getNome();
            case 1:
               return clientes.get(linha).getEndereco();
        }
        return null;
    }

    
    public void adicionarLinha(){
        clientes =  clienteDao.todas();
        this.fireTableDataChanged();
    }
    
    public void excluirLinha(int selectedRow) {
        clienteDao.deletar(clientes.get(selectedRow));
        this.clientes.remove(selectedRow);
        this.fireTableRowsDeleted(selectedRow, selectedRow);
    }
    
    public Cliente pegarCliente(int linha){
        return clientes.get(linha);
    }
    
}
