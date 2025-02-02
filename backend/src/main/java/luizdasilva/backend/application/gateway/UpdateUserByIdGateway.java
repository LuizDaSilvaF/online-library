package luizdasilva.backend.application.gateway;

import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.core.exception.UserDoesNotExistException;

import java.util.UUID;

public interface UpdateUserByIdGateway {
    void updateUserById(UUID id, User user) throws InternalServerErrorException;
}
