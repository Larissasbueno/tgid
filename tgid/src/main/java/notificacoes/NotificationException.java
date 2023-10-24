package notificacoes;

// Exceção personalizada para erros de notificações
public class NotificationException extends Exception {
    public NotificationException(String message) {
        super(message);
    }
}
