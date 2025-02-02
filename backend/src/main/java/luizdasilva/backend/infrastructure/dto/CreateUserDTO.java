package luizdasilva.backend.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import luizdasilva.backend.core.domain.enums.UserTypeEnum;

public record CreateUserDTO(
        @NotBlank(message = "Username is required.")
        String username,
        @NotBlank(message = "email is required.")
        String email,
        @NotBlank(message = "password is required.")
        String password,
        @NotNull(message = "User type is required.")
        UserTypeEnum type
) {
}
