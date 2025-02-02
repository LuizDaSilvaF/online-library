package luizdasilva.backend.infrastructure.controller;

import jakarta.validation.Valid;
import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.EmailAlreadyExistsException;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.core.exception.UserDoesNotExistException;
import luizdasilva.backend.infrastructure.dto.CreateUserDTO;
import luizdasilva.backend.infrastructure.entity.UserEntity;
import luizdasilva.backend.infrastructure.mapper.UserMapper;
import luizdasilva.backend.usecase.user.CreateUserUseCase;
import luizdasilva.backend.usecase.user.GetUserByIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, GetUserByIdUseCase getUserByIdUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid CreateUserDTO createUserDTO) throws EmailAlreadyExistsException, InternalServerErrorException {
        User user = userMapper.toUser(createUserDTO);
        createUserUseCase.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) throws UserDoesNotExistException, InternalServerErrorException {
        User user = getUserByIdUseCase.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
