package taxas;

public class TaxaSistema {
    private double valor;
    private String descricao;

    public TaxaSistema(double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    // Getters e Setters para os atributos
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
