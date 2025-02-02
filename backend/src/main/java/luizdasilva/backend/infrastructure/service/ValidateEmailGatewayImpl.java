package luizdasilva.backend.infrastructure.service;

import luizdasilva.backend.application.gateway.ValidateEmailGateway;
import luizdasilva.backend.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidateEmailGatewayImpl implements ValidateEmailGateway {
    private final UserEntityRepository userEntityRepository;

    public ValidateEmailGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean validate(String email) {
        return userEntityRepository.existsByEmail(email);
    }
}
