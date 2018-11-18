package venda.visao;

import javax.swing.table.AbstractTableModel;

public abstract class TableModel extends AbstractTableModel{
    
    protected String[] colunas;
    
    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }
    
     @Override
    public int getColumnCount() {
        return colunas.length;
    }
}
