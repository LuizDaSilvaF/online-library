package luizdasilva.backend.infrastructure.service;

import luizdasilva.backend.application.gateway.GetAllUsersGateway;
import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.infrastructure.entity.UserEntity;
import luizdasilva.backend.infrastructure.mapper.UserMapper;
import luizdasilva.backend.infrastructure.repository.UserEntityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllUsersGatewayImpl implements GetAllUsersGateway {
    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;

    public GetAllUsersGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAll() {
        List<UserEntity> entities= userEntityRepository.findAll();
        List<User> users = new ArrayList<>();

        entities.forEach(userEntity -> {
            users.add(userMapper.toUser(userEntity));
        });

        return users;
    }
}
