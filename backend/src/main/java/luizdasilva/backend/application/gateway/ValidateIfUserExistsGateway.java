package luizdasilva.backend.application.gateway;

import java.util.UUID;

public interface ValidateIfUserExistsGateway {
    Boolean validateIfUserExists(UUID id);
}
