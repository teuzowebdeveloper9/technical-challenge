package desafio.junior.services;

import desafio.junior.DTOs.RegisterDTO;
import desafio.junior.entitys.Registrations;
import desafio.junior.repositorys.RegistrationsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegistrationServices {

    private final RegistrationsRepository registrationsRepository;

    public RegistrationServices(RegistrationsRepository registrationsRepository) {
        this.registrationsRepository = registrationsRepository;
    }

    public ResponseEntity<Registrations> createRegistrations(Registrations dto){
        Registrations newRegistration = new Registrations();

        newRegistration.setCourse(dto.getCourse());
        newRegistration.setCodeRegistration(dto.getCodeRegistration());
        newRegistration.setStudent(dto.getStudent());
        newRegistration.setStartIn(dto.getStartIn());

       Registrations registrationSaved = registrationsRepository.save(newRegistration);

        return ResponseEntity.status(HttpStatus.CREATED).body(registrationSaved);
    }

    public ResponseEntity<Void> deleteRegistration(UUID id){
        Registrations deletedRegistration =  registrationsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration NOT FOUND"));
        
        registrationsRepository.delete(deletedRegistration);

        return ResponseEntity.notFound().build();
    }

    public List<Registrations> ListAllRegistration(){
       return registrationsRepository.findAll();
    }
}
