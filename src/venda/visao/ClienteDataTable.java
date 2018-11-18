package venda.visao;

import java.util.ArrayList;
import venda.controlador.ClienteDaoImpl;
import venda.controlador.ClienteDao;
import venda.modelo.Cliente;

public class ClienteDataTable extends TableModel {

    private final ClienteDao clienteDao = new ClienteDaoImpl();
    private ArrayList<venda.modelo.Cliente> clientes = clienteDao.todos();

    public ClienteDataTable() {
        colunas = new String[]{"Nome", "Endereço"};
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    /**
     *
     * @param linha
     * @param coluna
     * @return
     */
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return clientes.get(linha).getNome();
            case 1:
                return clientes.get(linha).getEndereco();
        }
        return null;
    }

    public void adicionarLinha() {
        clientes = clienteDao.todos();
        this.fireTableDataChanged();
    }

    public void excluirLinha(int selectedRow) {
        clienteDao.deletar(clientes.get(selectedRow));
        this.clientes.remove(selectedRow);
        this.fireTableRowsDeleted(selectedRow, selectedRow);
    }

    public Cliente pegarCliente(int linha) {
        return clientes.get(linha);
    }

}
