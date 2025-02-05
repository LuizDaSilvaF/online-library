package luizdasilva.backend.application.usecaseimpl.user;

import luizdasilva.backend.application.gateway.user.ValidateIfUserExistsGateway;
import luizdasilva.backend.usecase.user.ValidateIfUserExistsUseCase;

import java.util.UUID;

public class ValidateIfUserExistsUseCaseImpl implements ValidateIfUserExistsUseCase {
    private final ValidateIfUserExistsGateway validateIfUserExistsGateway;

    public ValidateIfUserExistsUseCaseImpl(ValidateIfUserExistsGateway validateIfUserExistsGateway) {
        this.validateIfUserExistsGateway = validateIfUserExistsGateway;
    }

    @Override
    public Boolean validateIfUserExists(UUID id) {
        return validateIfUserExistsGateway.validateIfUserExists(id);
    }
}
