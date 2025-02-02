package luizdasilva.backend.application.usecaseimpl;

import luizdasilva.backend.application.gateway.GetUserByIdGateway;
import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.core.exception.UserDoesNotExistException;
import luizdasilva.backend.usecase.user.GetUserByIdUseCase;
import luizdasilva.backend.usecase.user.ValidateIfUserExistsUseCase;

import java.util.UUID;

public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {
    private final GetUserByIdGateway getUserByIdGateway;
    private final ValidateIfUserExistsUseCase validateIfUserExistsUseCase;

    public GetUserByIdUseCaseImpl(GetUserByIdGateway getUserByIdGateway, ValidateIfUserExistsUseCase validateIfUserExistsUseCase) {
        this.getUserByIdGateway = getUserByIdGateway;
        this.validateIfUserExistsUseCase = validateIfUserExistsUseCase;
    }

    @Override
    public User getUser(UUID id) throws UserDoesNotExistException, InternalServerErrorException {
        if(!validateIfUserExistsUseCase.validateIfUserExists(id)){
            throw new UserDoesNotExistException("There is no user registered with the id: "+id);
        }

        return getUserByIdGateway.getUser(id);
    }
}
