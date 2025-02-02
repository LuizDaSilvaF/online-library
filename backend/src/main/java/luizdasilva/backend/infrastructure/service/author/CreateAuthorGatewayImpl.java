package luizdasilva.backend.infrastructure.service.author;

import luizdasilva.backend.application.gateway.author.CreateAuthorGateway;
import luizdasilva.backend.core.domain.Author;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.infrastructure.entity.AuthorEntity;
import luizdasilva.backend.infrastructure.mapper.AuthorMapper;
import luizdasilva.backend.infrastructure.repository.AuthorEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAuthorGatewayImpl implements CreateAuthorGateway {
    private final AuthorEntityRepository authorEntityRepository;
    private final AuthorMapper authorMapper;

    public CreateAuthorGatewayImpl(AuthorEntityRepository authorEntityRepository, AuthorMapper authorMapper) {
        this.authorEntityRepository = authorEntityRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public Boolean createAuthor(Author author) throws InternalServerErrorException {
        try{
            AuthorEntity entity = authorMapper.toAuthorEntity(author);
            authorEntityRepository.save(entity);
            return true;
        }catch (Exception ex){
            throw new InternalServerErrorException("Error trying to save author: " + ex.getMessage());
        }
    }
}
