package luizdasilva.backend.application.gateway;

import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.InternalServerErrorException;

public interface CreateUserGateway {
    Boolean create(User user) throws InternalServerErrorException;
}
