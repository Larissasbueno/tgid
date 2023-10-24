package transacoes;

public class TransactionService {
    public void realizarTransacao() throws TransactionException {
        try {
            // Lógica da transação
            if (true) {
                throw new TransactionException("Erro na transação: condição não atendida.");
            }
        } catch (Exception e) {
            throw new TransactionException("Erro na transação: " + e.getMessage());
        }
    }
}