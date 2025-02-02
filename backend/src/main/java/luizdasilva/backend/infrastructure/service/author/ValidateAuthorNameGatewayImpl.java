package luizdasilva.backend.infrastructure.service.author;

import luizdasilva.backend.application.gateway.author.ValidateAuthorNameGateway;
import luizdasilva.backend.infrastructure.repository.AuthorEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidateAuthorNameGatewayImpl implements ValidateAuthorNameGateway {
    private final AuthorEntityRepository authorEntityRepository;

    public ValidateAuthorNameGatewayImpl(AuthorEntityRepository authorEntityRepository) {
        this.authorEntityRepository = authorEntityRepository;
    }

    @Override
    public Boolean validateAuthorName(String name) {
        return authorEntityRepository.existsByName(name);
    }
}
