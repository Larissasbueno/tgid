package br.com.tgid;

import clientes.CPFValidationException;
import clientes.CPFValidationService;
import notificacoes.NotificationException;
import notificacoes.NotificationService;
import transacoes.TransactionException;
import transacoes.TransactionService;

public class Main {
    public static void main(String[] args) {
        try {
            TransactionService transactionService = new TransactionService();
            transactionService.realizarTransacao();
        } catch (TransactionException e) {
            System.err.println("Erro na transação: " + e.getMessage());
        }

        try {
            CPFValidationService cpfValidationService = new CPFValidationService();
            cpfValidationService.validarCPF("12345678901");
        } catch (CPFValidationException e) {
            System.err.println("Erro na validação do CPF: " + e.getMessage());
        }

        try {
            NotificationService notificationService = new NotificationService();
            notificationService.enviarNotificacao();
        } catch (NotificationException e) {
            System.err.println("Erro no envio de notificação: " + e.getMessage());
        }
    }
}
