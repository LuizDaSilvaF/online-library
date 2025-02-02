package luizdasilva.backend.usecase.user;

import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.core.exception.InvalidData;
import luizdasilva.backend.core.exception.UserDoesNotExistException;

import java.util.UUID;

public interface UpdateUserByIdUseCase {
    void updateUserById(UUID id, User user) throws UserDoesNotExistException, InternalServerErrorException, InvalidData;
}
