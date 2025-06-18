package desafio.junior.controllers;

import desafio.junior.DTOs.RegistrationDTO;
import desafio.junior.entitys.Registrations;
import desafio.junior.services.RegistrationServices;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Registration")
public class RegistrationController {

    private final RegistrationServices registrationServices;

    public RegistrationController(RegistrationServices registrationServices) {
        this.registrationServices = registrationServices;
    }

    @GetMapping
    public List<Registrations> ListAllRegistration(){
       return registrationServices.ListAllRegistration();
    }

    @PostMapping
    public ResponseEntity<Registrations> createRegistrations(Registrations dto){
       return registrationServices.createRegistrations(dto);
    }

    @PutMapping("{id}")
    public  Registrations editRegistration(@PathVariable UUID id,@Valid @RequestBody RegistrationDTO dto){
        return registrationServices.editRegistration(id,dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable UUID id){
       return registrationServices.deleteRegistration(id);
    }
}
