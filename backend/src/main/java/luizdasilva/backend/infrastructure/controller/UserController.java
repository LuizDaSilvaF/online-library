package luizdasilva.backend.infrastructure.controller;

import jakarta.validation.Valid;
import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.*;
import luizdasilva.backend.infrastructure.dto.user.CreateUserDTO;
import luizdasilva.backend.infrastructure.dto.user.UpdateUserDTO;
import luizdasilva.backend.infrastructure.mapper.UserMapper;
import luizdasilva.backend.usecase.user.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final DeleteUserByIdUseCase deleteUserByIdUseCase;
    private final UpdateUserByIdUseCase updateUserByIdUseCase;
    private final UserMapper userMapper;

    public UserController(CreateUserUseCase createUserUseCase, GetUserByIdUseCase getUserByIdUseCase, GetAllUsersUseCase getAllUsersUseCase, DeleteUserByIdUseCase deleteUserByIdUseCase, UpdateUserByIdUseCase updateUserByIdUseCase, UserMapper userMapper) {
        this.createUserUseCase = createUserUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
        this.deleteUserByIdUseCase = deleteUserByIdUseCase;
        this.updateUserByIdUseCase = updateUserByIdUseCase;
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

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() throws NotFound {
        List<User> users = getAllUsersUseCase.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable UUID id) throws UserDoesNotExistException, InternalServerErrorException {
        deleteUserByIdUseCase.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable UUID id, @RequestBody UpdateUserDTO updateUserDTO) throws UserDoesNotExistException, InternalServerErrorException, InvalidData {
        updateUserByIdUseCase.updateUserById(id, userMapper.toUser(updateUserDTO));
        return ResponseEntity.status(HttpStatus.OK).body("User updated successfully.");
    }
}
