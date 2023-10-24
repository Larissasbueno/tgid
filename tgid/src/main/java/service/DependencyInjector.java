package service;

import clientes.CPFValidationService;
import empresas.CNPJValidationService;
import notificacoes.EmailNotificationService;
import notificacoes.SMSNotificationService;

public class DependencyInjector {
    private final ValidationService validationService;
    private final NotificationService notificationService;

    public DependencyInjector(ValidationService validationService, NotificationService notificationService) {
        this.validationService = validationService;
        this.notificationService = notificationService;
    }

    public ClienteService createClienteService() {
        return new ClienteService(validationService, notificationService);
    }

    public EmpresaService createEmpresaService() {
        return new EmpresaService(validationService, notificationService);
    }

    ValidationService cpfValidationService = new CPFValidationService();
    ValidationService cnpjValidationService = new CNPJValidationService();
    NotificationService emailNotificationService = (NotificationService) new EmailNotificationService();
    NotificationService smsNotificationService = (NotificationService) new SMSNotificationService();

    DependencyInjector injector = new DependencyInjector(cpfValidationService, emailNotificationService);

    ClienteService clienteService = injector.createClienteService();
    EmpresaService empresaService = injector.createEmpresaService();

}
