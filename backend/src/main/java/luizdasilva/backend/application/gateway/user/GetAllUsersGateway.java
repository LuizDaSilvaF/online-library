package luizdasilva.backend.application.gateway.user;

import luizdasilva.backend.core.domain.User;

import java.awt.print.Pageable;
import java.util.List;

public interface GetAllUsersGateway {
    List<User> getAll();
}
