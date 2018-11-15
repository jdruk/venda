package venda.modelo;

public class Estoque implements Comparable<Estoque>{

    private int codigo;
    private Produto produto;
    private int quantidade;

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(Estoque outro) {
        return produto.getNome().compareTo(outro.getProduto().getNome());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Estoque estoque = (Estoque) obj;
        
        return produto != null ? produto.equals(estoque.getProduto()) : estoque.getProduto() == null;
    }

    @Override
    public String toString(){
        return produto.getNome();
    }
}
