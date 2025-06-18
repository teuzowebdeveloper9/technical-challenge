package desafio.junior.repositorys;

import desafio.junior.entitys.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface StudentsRepository extends JpaRepository<Students, UUID> {
     Optional<Students> findByName(String name);


    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.registrations WHERE s.id = :id")
    Optional<Students> findByIdWithRegistrations(@Param("id") UUID id);
}
