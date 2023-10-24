package service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CallbackService {
    public static void enviarCallback(String url, String corpo) {
        try {
            URL callbackUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) callbackUrl.openConnection();

            // Configurar a requisição HTTP
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Escrever o corpo da requisição (dados da transação, por exemplo)
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = corpo.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Obter a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // A requisição foi bem-sucedida
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder resposta = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    resposta.append(inputLine);
                }
                in.close();

                // Lógica de resposta do serviço de callback (simulação)
                String respostaDoCallback = resposta.toString();
                System.out.println("Resposta do serviço de callback: " + respostaDoCallback);
            } else {
                // A requisição falhou, trate os erros apropriados
                System.err.println("Falha na requisição HTTP. Código de resposta: " + responseCode);
                // Você pode implementar lógica de tratamento de erro específica aqui
            }
        } catch (Exception e) {
            // Lidar com exceções, como falha na conexão, URL inválida, etc.
            System.err.println("Erro ao enviar o callback: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String callbackUrl = "https://exemplo.com/callback";  // URL do serviço de callback
        String corpoDaTransacao = "Informações da transação...";  // Dados da transação

        enviarCallback(callbackUrl, corpoDaTransacao);
    }
}
