package luizdasilva.backend.infrastructure.config;

import luizdasilva.backend.application.gateway.user.*;
import luizdasilva.backend.application.usecaseimpl.user.*;
import luizdasilva.backend.usecase.user.*;
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

    @Bean
    public GetAllUsersUseCase getAllUsersUseCase(ChecksForUsersUseCase checksForUsersUseCase, GetAllUsersGateway getAllUsersGateway){
        return new GetAllUsersUseCaseImpl(checksForUsersUseCase, getAllUsersGateway);
    }

    @Bean
    public ChecksForUsersUseCase checksForUsersUseCase(ChecksForUsersGateway checksForUsersGateway){
        return new ChecksForUsersUseCaseImpl(checksForUsersGateway);
    }

    @Bean
    public DeleteUserByIdUseCase deleteUserByIdUseCase(DeleteUserByIdGateway deleteUserByIdGateway, ValidateIfUserExistsUseCase validateIfUserExistsUseCase){
        return new DeleteUserByIdUseCaseImpl(deleteUserByIdGateway, validateIfUserExistsUseCase);
    }

    @Bean
    public UpdateUserByIdUseCase updateUserByIdUseCase(UpdateUserByIdGateway updateUserByIdGateway, ValidateIfUserExistsUseCase validateIfUserExistsUseCase){
        return new UpdateUserByIdUseCaseImpl(validateIfUserExistsUseCase, updateUserByIdGateway);
    }
}
