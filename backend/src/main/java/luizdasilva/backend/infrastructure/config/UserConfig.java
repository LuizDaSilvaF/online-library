package luizdasilva.backend.infrastructure.config;

import luizdasilva.backend.application.gateway.CreateUserGateway;
import luizdasilva.backend.application.gateway.ValidateEmailGateway;
import luizdasilva.backend.application.usecaseimpl.CreateUserUseCaseImpl;
import luizdasilva.backend.application.usecaseimpl.ValidateEmailUseCaseImpl;
import luizdasilva.backend.usecase.user.CreateUserUseCase;
import luizdasilva.backend.usecase.user.ValidateEmailUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public ValidateEmailUseCase validateEmailUseCase(ValidateEmailGateway validateEmailGateway){
        return new ValidateEmailUseCaseImpl(validateEmailGateway);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(ValidateEmailUseCase validateEmailUseCase, CreateUserGateway createUserGateway){
        return new CreateUserUseCaseImpl(validateEmailUseCase, createUserGateway);
    }
}
