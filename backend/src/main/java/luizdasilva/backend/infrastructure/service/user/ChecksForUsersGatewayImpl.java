package luizdasilva.backend.infrastructure.service.user;

import luizdasilva.backend.application.gateway.user.ChecksForUsersGateway;
import luizdasilva.backend.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class ChecksForUsersGatewayImpl implements ChecksForUsersGateway {
    private final UserEntityRepository userEntityRepository;

    public ChecksForUsersGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean verify() {
        return userEntityRepository.existsAny();
    }
}
