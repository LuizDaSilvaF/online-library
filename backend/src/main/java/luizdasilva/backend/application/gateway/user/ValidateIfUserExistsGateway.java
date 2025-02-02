package luizdasilva.backend.application.gateway.user;

import java.util.UUID;

public interface ValidateIfUserExistsGateway {
    Boolean validateIfUserExists(UUID id);
}
