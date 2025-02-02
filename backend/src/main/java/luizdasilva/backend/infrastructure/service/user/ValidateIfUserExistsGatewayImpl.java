package luizdasilva.backend.infrastructure.service.user;

import luizdasilva.backend.application.gateway.user.ValidateIfUserExistsGateway;
import luizdasilva.backend.infrastructure.mapper.UserMapper;
import luizdasilva.backend.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidateIfUserExistsGatewayImpl implements ValidateIfUserExistsGateway {
    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;

    public ValidateIfUserExistsGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Boolean validateIfUserExists(UUID id) {
        return userEntityRepository.existsById(id);
    }
}
