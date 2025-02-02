package luizdasilva.backend.infrastructure.dto.user;

import luizdasilva.backend.core.domain.enums.UserTypeEnum;

public record UpdateUserDTO(
        String username,
        String email,
        String password,
        UserTypeEnum type
) {
}
