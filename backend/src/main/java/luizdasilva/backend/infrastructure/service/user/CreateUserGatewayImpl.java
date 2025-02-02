package luizdasilva.backend.infrastructure.service.user;

import luizdasilva.backend.application.gateway.user.CreateUserGateway;
import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.infrastructure.entity.UserEntity;
import luizdasilva.backend.infrastructure.mapper.UserMapper;
import luizdasilva.backend.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateUserGatewayImpl implements CreateUserGateway {
    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;

    public CreateUserGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Boolean create(User user) throws InternalServerErrorException {
        try{
            UserEntity entity = userMapper.toUserEntity(user);
            userEntityRepository.save(entity);
            return true;
        }catch (Exception ex){
            throw new InternalServerErrorException("Error trying to save user: " + ex.getMessage());
        }
    }
}
