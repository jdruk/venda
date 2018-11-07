package venda.modelo;

public class Cliente extends Pessoa {

    private boolean planoDeFidelidade;
    private Endereco endereco;

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

}
