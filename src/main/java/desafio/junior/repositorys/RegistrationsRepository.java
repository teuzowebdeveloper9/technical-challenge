package desafio.junior.repositorys;

import desafio.junior.entitys.Registrations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistrationsRepository extends JpaRepository<Registrations, UUID>
{
}
