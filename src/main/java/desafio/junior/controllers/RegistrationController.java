package desafio.junior.controllers;

import desafio.junior.DTOs.RegistrationDTO;
import desafio.junior.entitys.Registrations;
import desafio.junior.services.RegistrationServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
            summary = "Retrieve resource",
            description = "Retrieves a resource or a list of resources."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public List<Registrations> ListAllRegistration(){
       return registrationServices.ListAllRegistration();
    }

    @PostMapping
    @Operation(
            summary = "Create resource",
            description = "Creates a new resource."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Resource created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    public ResponseEntity<Registrations> createRegistrations(Registrations dto){
       return registrationServices.createRegistrations(dto);
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Update resource",
            description = "Updates an existing resource."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resource updated successfully"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public  Registrations editRegistration(@PathVariable UUID id,@Valid @RequestBody RegistrationDTO dto){
        return registrationServices.editRegistration(id,dto);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Delete resource",
            description = "Deletes an existing resource."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Resource deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public ResponseEntity<Void> deleteRegistration(@PathVariable UUID id){
       return registrationServices.deleteRegistration(id);
    }
}
