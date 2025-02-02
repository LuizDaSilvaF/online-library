package luizdasilva.backend.infrastructure.service.user;

import luizdasilva.backend.application.gateway.user.GetUserByIdGateway;
import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.infrastructure.entity.UserEntity;
import luizdasilva.backend.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetUserByIdGatewayImpl implements GetUserByIdGateway {
    private final UserEntityRepository userEntityRepository;

    public GetUserByIdGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public User getUser(UUID id) throws InternalServerErrorException {
        try{
            UserEntity entity = userEntityRepository.findById(id).get();

            return new User(
                    entity.getId(),
                    entity.getUsername(),
                    entity.getEmail(),
                    entity.getPassword(),
                    entity.getType(),
                    entity.getCreatedAt(),
                    entity.getUpdatedAt()
            );
        }catch (Exception ex){
            throw new InternalServerErrorException("Error trying to search for user: " + ex.getMessage());
        }
    }
}
