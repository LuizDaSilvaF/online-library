package luizdasilva.backend.application.gateway.user;

import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.InternalServerErrorException;

public interface CreateUserGateway {
    Boolean create(User user) throws InternalServerErrorException;
}
