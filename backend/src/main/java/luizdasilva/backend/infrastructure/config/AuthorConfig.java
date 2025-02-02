package luizdasilva.backend.infrastructure.config;

import luizdasilva.backend.application.gateway.author.CreateAuthorGateway;
import luizdasilva.backend.application.gateway.author.ValidateAuthorNameGateway;
import luizdasilva.backend.application.usecaseimpl.author.CreateAuthorUseCaseImpl;
import luizdasilva.backend.application.usecaseimpl.author.ValidateAuthorNameUseCaseImpl;
import luizdasilva.backend.usecase.author.CreateAuthorUseCase;
import luizdasilva.backend.usecase.author.ValidateAuthorNameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorConfig {
    @Bean
    public CreateAuthorUseCase createAuthorUseCase(ValidateAuthorNameUseCase validateAuthorNameUseCase, CreateAuthorGateway createAuthorGateway){
        return new CreateAuthorUseCaseImpl(validateAuthorNameUseCase, createAuthorGateway);
    }

    @Bean
    public ValidateAuthorNameUseCase validateAuthorNameUseCase(ValidateAuthorNameGateway validateAuthorNameGateway){
        return new ValidateAuthorNameUseCaseImpl(validateAuthorNameGateway);
    }
}
