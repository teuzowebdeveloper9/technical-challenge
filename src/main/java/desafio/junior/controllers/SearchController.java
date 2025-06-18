package desafio.junior.controllers;

import desafio.junior.entitys.Registrations;
import desafio.junior.entitys.Students;
import desafio.junior.services.RegistrationServices;
import desafio.junior.services.StudentsServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
            summary = "Retrieve resource",
            description = "Retrieves a resource or a list of resources."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public Optional<Students> searchStudent (@PathVariable UUID id){
        return studentsServices.findById(id);
    }

    @GetMapping("{name}")
    @Operation(
            summary = "Retrieve resource",
            description = "Retrieves a resource or a list of resources."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public Optional<Students> searchStudentByName(@PathVariable String name){
        return studentsServices.findByName(name);
    }

    @GetMapping("{course}")
    @Operation(
            summary = "Retrieve resource",
            description = "Retrieves a resource or a list of resources."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public Optional<Registrations> findByCourse(String course){
       return registrationServices.findByCourse(course);
    }

    @GetMapping("{registrationId}")
    @Operation(
            summary = "Retrieve resource",
            description = "Retrieves a resource or a list of resources."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public Optional<Registrations> findById(@PathVariable UUID id){
       return registrationServices.findById(id);
    }

    @GetMapping("rq")
    @Operation(
            summary = "Retrieve resource",
            description = "Retrieves a resource or a list of resources."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
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
    @Operation(
            summary = "Retrieve resource",
            description = "Retrieves a resource or a list of resources."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
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
    @Operation(
            summary = "Retrieve resource",
            description = "Retrieves a resource or a list of resources."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public List<Registrations> listRegistrations(@PathVariable UUID id){
        return studentsServices.listRegistrations(id);
    }


}
