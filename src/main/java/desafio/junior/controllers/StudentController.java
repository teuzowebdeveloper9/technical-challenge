package desafio.junior.controllers;

import desafio.junior.DTOs.RegisterDTO;
import desafio.junior.DTOs.StudentsDTO;
import desafio.junior.entitys.Students;
import desafio.junior.services.StudentsServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentsServices studentsServices;

    public StudentController(StudentsServices studentsServices) {
        this.studentsServices = studentsServices;
    }

    @PostMapping("/")
    @Operation(
            summary = "Create resource",
            description = "Creates a new resource."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Resource created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    public ResponseEntity<Students> createStudent(@Valid @RequestBody StudentsDTO dto){
        return  studentsServices.createStudent(dto);
    }

    @PostMapping("/register")
    @Operation(
            summary = "Create resource",
            description = "Creates a new resource."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Resource created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    public Students register(@Valid @RequestBody RegisterDTO registerDTO){

        return studentsServices.addRegistration(registerDTO);
    }


    @GetMapping("/")
    @Operation(
            summary = "Retrieve resource",
            description = "Retrieves a resource or a list of resources."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    public List<Students> ListAllStudents(){
      return   studentsServices.ListAllStudents();
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
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID id){
       return studentsServices.deleteStudent(id);
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
    public ResponseEntity<Students> editStudent(@PathVariable UUID id,@Valid @RequestBody StudentsDTO dto){
        return studentsServices.editStudent(id,dto);
    }

}
