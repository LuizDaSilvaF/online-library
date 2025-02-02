package luizdasilva.backend.infrastructure.config;

import luizdasilva.backend.application.gateway.CreateUserGateway;
import luizdasilva.backend.application.gateway.GetUserByIdGateway;
import luizdasilva.backend.application.gateway.ValidateIfUserExistsGateway;
import luizdasilva.backend.application.gateway.ValidateEmailGateway;
import luizdasilva.backend.application.usecaseimpl.CreateUserUseCaseImpl;
import luizdasilva.backend.application.usecaseimpl.GetUserByIdUseCaseImpl;
import luizdasilva.backend.application.usecaseimpl.ValidateIfUserExistsUseCaseImpl;
import luizdasilva.backend.application.usecaseimpl.ValidateEmailUseCaseImpl;
import luizdasilva.backend.usecase.user.CreateUserUseCase;
import luizdasilva.backend.usecase.user.GetUserByIdUseCase;
import luizdasilva.backend.usecase.user.ValidateIfUserExistsUseCase;
import luizdasilva.backend.usecase.user.ValidateEmailUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public CreateUserUseCase createUserUseCase(ValidateEmailUseCase validateEmailUseCase, CreateUserGateway createUserGateway){
        return new CreateUserUseCaseImpl(validateEmailUseCase, createUserGateway);
    }

    @Bean
    public ValidateEmailUseCase validateEmailUseCase(ValidateEmailGateway validateEmailGateway){
        return new ValidateEmailUseCaseImpl(validateEmailGateway);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(ValidateIfUserExistsUseCase validateIfUserExistsUseCase, GetUserByIdGateway getUserByIdGateway){
        return new GetUserByIdUseCaseImpl(getUserByIdGateway, validateIfUserExistsUseCase);
    }

    @Bean
    public ValidateIfUserExistsUseCase validateIfUserExistsUseCase(ValidateIfUserExistsGateway validateIfUserExistsGateway){
        return new ValidateIfUserExistsUseCaseImpl(validateIfUserExistsGateway);
    }

}
