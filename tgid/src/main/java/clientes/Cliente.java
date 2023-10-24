package clientes;

import lombok.Getter;
import usuarios.Usuario;

public class Cliente extends Usuario {

    private static final String senha = "123456";

    private String nome;

    @Getter
    private String cpf;

    public Cliente(String nome, String cpf) {
        super(nome, cpf, senha);
        this.nome = nome;
        if (validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    // Método para validar o CPF
    private boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos após a remoção
        if (cpf.length() != 11) {
            return false;
        }

        // Exemplo de validação com expressão regular (formato 000.000.000-00)
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
