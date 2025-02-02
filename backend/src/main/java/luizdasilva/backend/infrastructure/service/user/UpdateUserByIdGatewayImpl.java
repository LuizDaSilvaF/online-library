package luizdasilva.backend.infrastructure.service.user;

import luizdasilva.backend.application.gateway.user.UpdateUserByIdGateway;
import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.EmailAlreadyExistsException;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.infrastructure.entity.UserEntity;
import luizdasilva.backend.infrastructure.mapper.UserMapper;
import luizdasilva.backend.infrastructure.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UpdateUserByIdGatewayImpl implements UpdateUserByIdGateway {
    private final UserEntityRepository userEntityRepository;
    private final UserMapper userMapper;

    public UpdateUserByIdGatewayImpl(UserEntityRepository userEntityRepository, UserMapper userMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void updateUserById(UUID id, User user) throws InternalServerErrorException {
        try{
            UserEntity entity = userEntityRepository.findById(id).get();

            if(user.getEmail() != null){
                if(userEntityRepository.existsByEmail(user.getEmail()) && !user.getEmail().equals(entity.getEmail())){
                    throw new EmailAlreadyExistsException("Cannot update user because email " + user.getEmail() + " belongs to another user.");
                }
                entity.setEmail(user.getEmail());
            }
            if(user.getUsername() != null){
                entity.setUsername(user.getUsername());
            }
            if(user.getType() != null){
                entity.setType(user.getType());
            }
            if(user.getPassword() != null){
                entity.setPassword(user.getPassword());
            }
            entity.setUpdatedAt(LocalDateTime.now());

            userEntityRepository.save(entity);
        }catch (Exception ex){
            throw new InternalServerErrorException("Error trying to update user: " + ex.getMessage());
        }
    }
}
