package empresas;

// Exceção personalizada para erros de validação de CNPJ
public class CNPJValidationException extends Exception {
    public CNPJValidationException(String message) {
        super(message);
    }

}
