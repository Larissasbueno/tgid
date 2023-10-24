package transacoes;

// Exceção personalizada para erros de transações
public class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}
