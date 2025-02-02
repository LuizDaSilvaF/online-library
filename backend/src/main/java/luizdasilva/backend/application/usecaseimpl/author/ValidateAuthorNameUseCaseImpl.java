package luizdasilva.backend.application.usecaseimpl.author;

import luizdasilva.backend.application.gateway.author.ValidateAuthorNameGateway;
import luizdasilva.backend.usecase.author.ValidateAuthorNameUseCase;

public class ValidateAuthorNameUseCaseImpl implements ValidateAuthorNameUseCase {
    private final ValidateAuthorNameGateway validateAuthorNameGateway;

    public ValidateAuthorNameUseCaseImpl(ValidateAuthorNameGateway validateAuthorNameGateway) {
        this.validateAuthorNameGateway = validateAuthorNameGateway;
    }

    @Override
    public Boolean validateAuthorName(String name) {
        return validateAuthorNameGateway.validateAuthorName(name);
    }
}
