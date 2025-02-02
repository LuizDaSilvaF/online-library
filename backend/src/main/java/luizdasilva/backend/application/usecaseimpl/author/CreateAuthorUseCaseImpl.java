package luizdasilva.backend.application.usecaseimpl.author;

import luizdasilva.backend.application.gateway.author.CreateAuthorGateway;
import luizdasilva.backend.core.domain.Author;
import luizdasilva.backend.core.exception.AuthorAlreadySaved;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.usecase.author.CreateAuthorUseCase;
import luizdasilva.backend.usecase.author.ValidateAuthorNameUseCase;

public class CreateAuthorUseCaseImpl implements CreateAuthorUseCase {
    private final ValidateAuthorNameUseCase validateAuthorNameUseCase;
    private final CreateAuthorGateway createAuthorGateway;

    public CreateAuthorUseCaseImpl(ValidateAuthorNameUseCase validateAuthorNameUseCase, CreateAuthorGateway createAuthorGateway) {
        this.validateAuthorNameUseCase = validateAuthorNameUseCase;
        this.createAuthorGateway = createAuthorGateway;
    }

    @Override
    public void createAuthor(Author author) throws InternalServerErrorException, AuthorAlreadySaved {
        if(validateAuthorNameUseCase.validateAuthorName(author.getName())){
            throw new AuthorAlreadySaved("The author is already registered in the database.");
        }

        createAuthorGateway.createAuthor(author);
    }
}
