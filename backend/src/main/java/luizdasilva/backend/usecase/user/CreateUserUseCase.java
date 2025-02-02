package luizdasilva.backend.usecase.user;

import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.EmailAlreadyExistsException;
import luizdasilva.backend.core.exception.InternalServerErrorException;

public interface CreateUserUseCase {
    void create(User user) throws EmailAlreadyExistsException, InternalServerErrorException;
}
