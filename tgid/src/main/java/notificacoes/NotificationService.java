package notificacoes;

public abstract class NotificationService {
    public void enviarNotificacao() throws NotificationException {
        try {
            // Lógica de envio de notificação
            if (true) {
                throw new NotificationException("Erro na notificação: condição não atendida.");
            }
        } catch (Exception e) {
            throw new NotificationException("Erro no envio de notificação: " + e.getMessage());
        }
    }

    public abstract void sendNotification(String message);
}