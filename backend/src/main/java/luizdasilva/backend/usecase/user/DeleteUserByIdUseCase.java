package luizdasilva.backend.usecase.user;

import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.core.exception.UserDoesNotExistException;

import java.util.UUID;

public interface DeleteUserByIdUseCase {
    void deleteUserById(UUID id) throws UserDoesNotExistException, InternalServerErrorException;
}
