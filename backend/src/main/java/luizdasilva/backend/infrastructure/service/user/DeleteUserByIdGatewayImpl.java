package luizdasilva.backend.infrastructure.service.user;

import luizdasilva.backend.application.gateway.user.DeleteUserByIdGateway;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteUserByIdGatewayImpl implements DeleteUserByIdGateway {
    private final UserEntityRepository userEntityRepository;

    public DeleteUserByIdGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public void deleteUserById(UUID id) throws InternalServerErrorException {
        try{
            userEntityRepository.deleteById(id);
        }catch (Exception ex){
            throw new InternalServerErrorException("Error when trying to delete user: " + ex.getMessage());
        }
    }
}
