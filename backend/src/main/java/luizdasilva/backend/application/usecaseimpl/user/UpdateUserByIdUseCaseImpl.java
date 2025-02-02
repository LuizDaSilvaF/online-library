package luizdasilva.backend.application.usecaseimpl.user;

import luizdasilva.backend.application.gateway.user.UpdateUserByIdGateway;
import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.core.exception.InvalidData;
import luizdasilva.backend.core.exception.UserDoesNotExistException;
import luizdasilva.backend.usecase.user.UpdateUserByIdUseCase;
import luizdasilva.backend.usecase.user.ValidateIfUserExistsUseCase;

import java.util.Objects;
import java.util.UUID;

public class UpdateUserByIdUseCaseImpl implements UpdateUserByIdUseCase {
    private final ValidateIfUserExistsUseCase validateIfUserExistsUseCase;
    private final UpdateUserByIdGateway updateUserByIdGateway;

    public UpdateUserByIdUseCaseImpl(ValidateIfUserExistsUseCase validateIfUserExistsUseCase, UpdateUserByIdGateway updateUserByIdGateway) {
        this.validateIfUserExistsUseCase = validateIfUserExistsUseCase;
        this.updateUserByIdGateway = updateUserByIdGateway;
    }

    @Override
    public void updateUserById(UUID id, User user) throws UserDoesNotExistException, InternalServerErrorException, InvalidData {
        if(!validateIfUserExistsUseCase.validateIfUserExists(id)){
            throw new UserDoesNotExistException("There is no user registered with the id: " + id);
        }

        if (Objects.isNull(user.getUsername()) ||
                Objects.isNull(user.getEmail()) ||
                Objects.isNull(user.getPassword()) ||
                Objects.isNull(user.getType())) {
            throw new InvalidData("It is not possible to update the user, as some required fields are null.");
        }
        updateUserByIdGateway.updateUserById(id, user);
    }
}
