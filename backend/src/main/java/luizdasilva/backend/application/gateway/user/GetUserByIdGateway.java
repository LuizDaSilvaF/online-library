package luizdasilva.backend.application.gateway.user;

import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.InternalServerErrorException;

import java.util.UUID;

public interface GetUserByIdGateway {
    User getUser(UUID id) throws InternalServerErrorException;
}
