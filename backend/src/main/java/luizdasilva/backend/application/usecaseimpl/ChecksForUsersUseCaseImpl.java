package luizdasilva.backend.application.usecaseimpl;

import luizdasilva.backend.application.gateway.ChecksForUsersGateway;
import luizdasilva.backend.usecase.user.ChecksForUsersUseCase;

public class ChecksForUsersUseCaseImpl implements ChecksForUsersUseCase {
    private final ChecksForUsersGateway checksForUsersGateway;

    public ChecksForUsersUseCaseImpl(ChecksForUsersGateway checksForUsersGateway) {
        this.checksForUsersGateway = checksForUsersGateway;
    }

    @Override
    public Boolean verify() {
        return checksForUsersGateway.verify();
    }
}
