package luizdasilva.backend.usecase.user;

import java.util.UUID;

public interface ValidateIfUserExistsUseCase {
    Boolean validateIfUserExists(UUID id);
}
