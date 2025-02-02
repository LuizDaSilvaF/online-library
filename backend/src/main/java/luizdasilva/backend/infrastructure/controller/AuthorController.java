package luizdasilva.backend.infrastructure.controller;

import jakarta.validation.Valid;
import luizdasilva.backend.core.exception.AuthorAlreadySaved;
import luizdasilva.backend.core.exception.InternalServerErrorException;
import luizdasilva.backend.infrastructure.dto.author.CreateAuthorDTO;
import luizdasilva.backend.infrastructure.mapper.AuthorMapper;
import luizdasilva.backend.usecase.author.CreateAuthorUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final CreateAuthorUseCase createAuthorUseCase;
    private final AuthorMapper authorMapper;
    public AuthorController(CreateAuthorUseCase createAuthorUseCase, AuthorMapper authorMapper) {
        this.createAuthorUseCase = createAuthorUseCase;
        this.authorMapper = authorMapper;
    }

    @PostMapping
    public ResponseEntity<String> createAuthor(@RequestBody @Valid CreateAuthorDTO createAuthorDTO) throws InternalServerErrorException, AuthorAlreadySaved {
        createAuthorUseCase.createAuthor(authorMapper.toAuthor(createAuthorDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body("Author saved successfully.");
    }
}
