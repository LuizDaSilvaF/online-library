package luizdasilva.backend.application.gateway.author;

import luizdasilva.backend.core.domain.Author;
import luizdasilva.backend.core.exception.InternalServerErrorException;

public interface CreateAuthorGateway {
    Boolean createAuthor(Author author) throws InternalServerErrorException;
}
