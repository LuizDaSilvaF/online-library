package luizdasilva.backend.application.usecaseimpl;

import luizdasilva.backend.application.gateway.ValidateEmailGateway;
import luizdasilva.backend.usecase.user.ValidateEmailUseCase;

public class ValidateEmailUseCaseImpl implements ValidateEmailUseCase {
    private final ValidateEmailGateway validateEmailGateway;

    public ValidateEmailUseCaseImpl(ValidateEmailGateway validateEmailGateway) {
        this.validateEmailGateway = validateEmailGateway;
    }

    @Override
    public Boolean validate(String email) {
        return validateEmailGateway.validate(email);
    }
}
