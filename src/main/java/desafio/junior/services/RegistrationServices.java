package desafio.junior.services;

import desafio.junior.DTOs.RegistrationDTO;
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

    public Registrations findByCourse(String course){
      Registrations registration =   registrationsRepository.findByCourse(course)
                 .orElseThrow(() -> new RuntimeException("registration NOT FOUND"));

      return registration;
    }

    public Registrations findById(UUID id){
        Registrations registration = registrationsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("registration NOT FOUND"));

        return registration;
    }

    public Registrations editRegistration(UUID id, RegistrationDTO dto){
        Registrations registrationFind = registrationsRepository
                .findById(id).orElseThrow(() -> new RuntimeException("registration NOT FOUND"));

        registrationFind.setCodeRegistration(dto.codeRegistration());
        registrationFind.setStartIn(dto.startIn());
        registrationFind.setCourse(dto.course());

       Registrations registrationSaved = registrationsRepository.save(registrationFind);

       return registrationSaved;
    }

    public List<Registrations> ListAllRegistration(){
       return registrationsRepository.findAll();
    }
}
