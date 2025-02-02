package luizdasilva.backend.infrastructure.controller;

import jakarta.validation.Valid;
import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.EmailAlreadyExistsException;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.infrastructure.dto.CreateUserDTO;
import luizdasilva.backend.infrastructure.entity.UserEntity;
import luizdasilva.backend.infrastructure.mapper.UserMapper;
import luizdasilva.backend.usecase.user.CreateUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid CreateUserDTO createUserDTO) throws EmailAlreadyExistsException, InternalServerErrorException {
        User user = userMapper.toUser(createUserDTO);
        createUserUseCase.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso");
    }
}
