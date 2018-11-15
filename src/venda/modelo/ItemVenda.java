package venda.modelo;

import java.math.BigDecimal;

public class ItemVenda {
    
    private int codigo;
    private Produto produto;
    private Venda venda;
    private int quantidade;
    private BigDecimal valorVenda;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ItemVenda item = (ItemVenda) obj;
        if(this.produto.equals(item.getProduto()) && this.venda.equals(item.venda)){
            return true;
        }
        
        return codigo != 0 ? codigo == item.getCodigo() : produto.getCodigo() == 0;
    }
    
}
