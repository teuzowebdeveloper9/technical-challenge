package desafio.junior.controllers;

import desafio.junior.entitys.Registrations;
import desafio.junior.entitys.Students;
import desafio.junior.services.RegistrationServices;
import desafio.junior.services.StudentsServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final StudentsServices studentsServices;
    private final RegistrationServices registrationServices;

    public SearchController(StudentsServices studentsServices, RegistrationServices registrationServices) {
        this.studentsServices = studentsServices;
        this.registrationServices = registrationServices;
    }

    @GetMapping("{id}")
    public Optional<Students> searchStudent (@PathVariable UUID id){
        return studentsServices.findById(id);
    }

    @GetMapping("{name}")
    public Optional<Students> searchStudentByName(@PathVariable String name){
        return studentsServices.findByName(name);
    }

    @GetMapping("{course}")
    public Optional<Registrations> findByCourse(String course){
       return registrationServices.findByCourse(course);
    }

    @GetMapping("{registrationId}")
    public Optional<Registrations> findById(@PathVariable UUID id){
       return registrationServices.findById(id);
    }

    @GetMapping("rq")
    public ResponseEntity<?> searchRegistration(@PathVariable("rq") String query){
        Optional<Registrations> registration = registrationServices.findByCourse(query);

        if(registration != null){
            return ResponseEntity.ok(registration);
        }

        try {
            UUID id =UUID.fromString(query);

            return registrationServices.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }catch (IllegalArgumentException e){
          return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{q}")
    public ResponseEntity<?> search(@PathVariable("q") String query) {
        Optional<Students> student = studentsServices.findByName(query);

        if (student != null) {
            return ResponseEntity.ok(student);
        }

        try {
            UUID id = UUID.fromString(query);
            return studentsServices.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());

        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{register}")
    public List<Registrations> listRegistrations(@PathVariable UUID id){
        return studentsServices.listRegistrations(id);
    }


}
