package luizdasilva.backend.usecase.author;

import luizdasilva.backend.core.domain.Author;
import luizdasilva.backend.core.exception.AuthorAlreadySaved;
import luizdasilva.backend.core.exception.InternalServerErrorException;

public interface CreateAuthorUseCase {
    void createAuthor(Author author) throws InternalServerErrorException, AuthorAlreadySaved;
}
