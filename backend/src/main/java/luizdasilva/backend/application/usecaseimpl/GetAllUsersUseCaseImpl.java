package luizdasilva.backend.application.usecaseimpl;

import luizdasilva.backend.application.gateway.GetAllUsersGateway;
import luizdasilva.backend.core.domain.User;
import luizdasilva.backend.core.exception.NotFound;
import luizdasilva.backend.usecase.user.ChecksForUsersUseCase;
import luizdasilva.backend.usecase.user.GetAllUsersUseCase;

import java.awt.print.Pageable;
import java.util.List;

public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {
    private final ChecksForUsersUseCase checksForUsersUseCase;
    private final GetAllUsersGateway getAllUsersGateway;

    public GetAllUsersUseCaseImpl(ChecksForUsersUseCase checksForUsersUseCase, GetAllUsersGateway getAllUsersGateway) {
        this.checksForUsersUseCase = checksForUsersUseCase;
        this.getAllUsersGateway = getAllUsersGateway;
    }

    @Override
    public List<User> getAll() throws NotFound {
        if(!checksForUsersUseCase.verify()){
            throw new NotFound("There are no users registered in the database.");
        }

        return getAllUsersGateway.getAll();
    }
}
