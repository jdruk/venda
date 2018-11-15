package venda.modelo;

public class Cliente extends Pessoa implements Comparable<Cliente>{

    private Integer codigo;
    private String rg;
    private String nome;
    private boolean planoDeFidelidade;
    private Endereco endereco;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isPlanoDeFidelidade() {
        return planoDeFidelidade;
    }

    public void setPlanoDeFidelidade(boolean planoDeFidelidade) {
        this.planoDeFidelidade = planoDeFidelidade;
    }

    @Override
    public int compareTo(Cliente outroCliente) {
        return nome.compareTo(outroCliente.getNome());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
