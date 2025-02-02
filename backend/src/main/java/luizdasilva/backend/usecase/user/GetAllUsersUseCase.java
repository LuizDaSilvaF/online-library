package luizdasilva.backend.usecase.user;

import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.NotFound;

import java.awt.print.Pageable;
import java.util.List;

public interface GetAllUsersUseCase {
    List<User> getAll() throws NotFound;
}
