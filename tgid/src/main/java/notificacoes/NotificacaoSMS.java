package notificacoes;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

public class NotificacaoSMS {
    // Credenciais da conta Twilio
    private static final String ACCOUNT_SID = "seu_account_sid";
    private static final String AUTH_TOKEN = "seu_auth_token";

    public <OkHttpClient> void enviarSMS(String numero, String mensagem) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "from=seu_numero&to=" + numero + "&text=" + mensagem);
        Request request = new Request.Builder()
                .url("https://api.servico-envio-sms.com/v1/sms")
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Bearer seu_token")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println("SMS enviado com sucesso para: " + numero);
        } catch (IOException e) {
            System.out.println("Erro ao enviar o SMS: " + e.getMessage());
        }
    }
}