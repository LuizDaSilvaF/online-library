package luizdasilva.backend.infrastructure.mapper;

import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.infrastructure.dto.CreateUserDTO;
import luizdasilva.backend.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toUserEntity(User user){
        return new UserEntity(
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getType(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    public User toUser(CreateUserDTO createUserDTO){
        return new User(
                createUserDTO.username(),
                createUserDTO.email(),
                createUserDTO.password(),
                createUserDTO.type()
        );
    }

    public User toUser(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getType(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
    }
}
