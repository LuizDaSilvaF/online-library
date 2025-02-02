package luizdasilva.backend.application.gateway.user;

import luizdasilva.backend.core.exception.InternalServerErrorException;

import java.util.UUID;

public interface DeleteUserByIdGateway {
    void deleteUserById(UUID id) throws InternalServerErrorException;
}
