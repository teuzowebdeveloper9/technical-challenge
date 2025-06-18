package desafio.junior.controllers;

import desafio.junior.entitys.Registrations;
import desafio.junior.entitys.Students;
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

    public SearchController(StudentsServices studentsServices) {
        this.studentsServices = studentsServices;
    }

    @GetMapping("{id}")
    public Optional<Students> searchStudent (@PathVariable UUID id){
        return studentsServices.findById(id);
    }

    @GetMapping("{name}")
    public Optional<Students> searchStudentByName(@PathVariable String name){
        return studentsServices.findByName(name);
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
    public List<Registrations> listRegistrations(UUID id){
        return studentsServices.listRegistrations(id);
    }
}
