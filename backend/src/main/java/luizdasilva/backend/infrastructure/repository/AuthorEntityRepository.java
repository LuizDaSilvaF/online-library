package luizdasilva.backend.infrastructure.repository;

import luizdasilva.backend.infrastructure.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorEntityRepository extends JpaRepository<AuthorEntity, UUID> {
    Boolean existsByName(String name);
}
