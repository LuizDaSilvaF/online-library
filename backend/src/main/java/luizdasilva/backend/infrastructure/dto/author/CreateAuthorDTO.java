package luizdasilva.backend.infrastructure.dto.author;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAuthorDTO(
        @NotBlank(message = "Author name is required.")
        @Size(min = 2, max = 50, message = "The author's name must have a minimum of 2 characters and a maximum of 50 characters.")
        String name
) {
}
