package luizdasilva.backend.application.usecaseimpl.user;

import luizdasilva.backend.application.gateway.user.DeleteUserByIdGateway;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.core.exception.UserDoesNotExistException;
import luizdasilva.backend.usecase.user.DeleteUserByIdUseCase;
import luizdasilva.backend.usecase.user.ValidateIfUserExistsUseCase;

import java.util.UUID;

public class DeleteUserByIdUseCaseImpl implements DeleteUserByIdUseCase {
    private final DeleteUserByIdGateway deleteUserByIdGateway;
    private final ValidateIfUserExistsUseCase validateIfUserExistsUseCase;

    public DeleteUserByIdUseCaseImpl(DeleteUserByIdGateway deleteUserByIdGateway, ValidateIfUserExistsUseCase validateIfUserExistsUseCase) {
        this.deleteUserByIdGateway = deleteUserByIdGateway;
        this.validateIfUserExistsUseCase = validateIfUserExistsUseCase;
    }

    @Override
    public void deleteUserById(UUID id) throws UserDoesNotExistException, InternalServerErrorException {
        if(!validateIfUserExistsUseCase.validateIfUserExists(id)){
            throw new UserDoesNotExistException("There is no user registered with the id: " + id);
        }
        deleteUserByIdGateway.deleteUserById(id);
    }
}
