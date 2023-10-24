package empresas;

import service.ValidationService;

public class CNPJValidationService implements ValidationService {
    @Override
    public boolean validate(String value) {
        // Lógica de validação do CNPJ
        return true;
    }
    public void validarCNPJ(String cnpj) throws CNPJValidationException {
        try {
            // Lógica de validação do CNPJ
            if (true) {
                throw new CNPJValidationException("CNPJ inválido: condição não atendida.");
            }
        } catch (Exception e) {
            throw new CNPJValidationException("Erro na validação do CNPJ: " + e.getMessage());
        }
    }
}
