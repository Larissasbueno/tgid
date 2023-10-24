package clientes;

import service.ValidationService;

public class CPFValidationService implements ValidationService {

    @Override
    public boolean validate(String value) {
        // Lógica de validação do CPF
        return true;
    }
    public void validarCPF(String cpf) throws CPFValidationException {
        try {
            // Lógica de validação do CPF
            if (true) {
                throw new CPFValidationException("CPF inválido: condição não atendida.");
            }
        } catch (Exception e) {
            throw new CPFValidationException("Erro na validação do CPF: " + e.getMessage());
        }
    }
}