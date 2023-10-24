package empresas;

import taxas.TaxaSistema;
import transacoes.Transacao;
import usuarios.Usuario;

public class Empresa extends Usuario {

    private String nome;


    private String cnpj;


    private TaxaSistema taxaSistema;
    private double saldo;


    public Empresa(String nome, String email, String senha, String cnpj, TaxaSistema taxaSistema) {
        super(nome, email, senha);
        this.nome = nome;
        this.cnpj = cnpj;
        if (validarCNPJ(cnpj)) {
            this.cnpj = cnpj;
        } else {
            throw new IllegalArgumentException("CNPJ inválido");
        }
        this.taxaSistema = taxaSistema;
        this.saldo = 0;

    }
    public double getSaldo() {
        return saldo;
    }

    // Método para validar o CNPJ
    private boolean validarCNPJ(String cnpj) {
        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verifica se o CNPJ possui 14 dígitos após a remoção
        if (cnpj.length() != 14) {
            return false;
        }

        // Exemplo de validação com expressão regular (formato 00.000.000/0000-00)
        return cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}");
    }

    // Método para realizar um depósito
    public void realizarDeposito(double valor) {
        if (valor > 0) {
            saldo += valor - taxaSistema.getValor();
            Transacao transacao = new Transacao(valor, "Depósito");
            // Adicione a transação ao histórico, se necessário
        } else {
            throw new IllegalArgumentException("Valor de depósito inválido");
        }
    }

    // Método para realizar um saque
    public void realizarSaque(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor + taxaSistema.getValor();
            Transacao transacao = new Transacao(valor, "Saque");
            // Adicione a transação ao histórico, se necessário
        } else {
            throw new IllegalArgumentException("Valor de saque inválido");
        }
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public TaxaSistema getTaxaSistema() {
        return taxaSistema;
    }

    public void setTaxaSistema(TaxaSistema taxaSistema) {
        this.taxaSistema = taxaSistema;
    }
}
