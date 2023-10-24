package transacoes;

import java.util.Date;

public class Transacao {
    private double valor;
    private String tipo;
    private Date data;

    public Transacao(double valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
        this.data = new Date(); // Data atual
    }

    // Getters e Setters para os atributos
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
