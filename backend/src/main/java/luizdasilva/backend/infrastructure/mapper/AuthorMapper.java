package luizdasilva.backend.infrastructure.mapper;

import luizdasilva.backend.core.domain.Author;
import luizdasilva.backend.infrastructure.dto.author.CreateAuthorDTO;
import luizdasilva.backend.infrastructure.entity.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public Author toAuthor(CreateAuthorDTO createAuthorDTO){
        return new Author(createAuthorDTO.name());
    }

    public Author toAuthor(AuthorEntity authorEntity){
        return new Author(
                authorEntity.getId(),
                authorEntity.getName(),
                authorEntity.getCreatedAt(),
                authorEntity.getUpdatedAt()
        );
    }

    public AuthorEntity toAuthorEntity(Author author){
        return new AuthorEntity(
                author.getName(),
                author.getCreatedAt(),
                author.getUpdatedAt()
        );
    }
}
