package luizdasilva.backend.usecase.user;

import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.core.exception.UserDoesNotExistException;

import java.util.UUID;

public interface GetUserByIdUseCase {
    User getUser(UUID id) throws UserDoesNotExistException, InternalServerErrorException;
}
