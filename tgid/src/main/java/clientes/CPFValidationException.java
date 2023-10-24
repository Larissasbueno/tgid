package clientes;

// Exceção personalizada para erros de validação de CPF
public class CPFValidationException extends Exception {
    public CPFValidationException(String message) {
        super(message);
    }
}

