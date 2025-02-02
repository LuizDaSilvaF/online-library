package luizdasilva.backend.application.usecaseimpl;

import luizdasilva.backend.application.gateway.CreateUserGateway;
import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.EmailAlreadyExistsException;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.usecase.user.CreateUserUseCase;
import luizdasilva.backend.usecase.user.ValidateEmailUseCase;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final ValidateEmailUseCase validateEmailUseCase;
    private final CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(ValidateEmailUseCase validateEmailUseCase, CreateUserGateway createUserGateway) {
        this.validateEmailUseCase = validateEmailUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user) throws EmailAlreadyExistsException, InternalServerErrorException {
        if(validateEmailUseCase.validate(user.getEmail())){
            throw new EmailAlreadyExistsException("The email "+ user.getEmail() +" is already registered");
        }
        if(!createUserGateway.create(user)){
            throw new InternalServerErrorException("An error occurred while trying to save the user");
        }
    }
}
