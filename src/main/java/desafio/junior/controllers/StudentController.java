package desafio.junior.controllers;

import desafio.junior.DTOs.RegisterDTO;
import desafio.junior.DTOs.StudentsDTO;
import desafio.junior.entitys.Students;
import desafio.junior.services.StudentsServices;
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
    public ResponseEntity<Students> createStudent(@Valid @RequestBody StudentsDTO dto){
        return  studentsServices.createStudent(dto);
    }

    @PostMapping("/register")
    public Students register(@Valid @RequestBody RegisterDTO registerDTO){

        return studentsServices.addRegistration(registerDTO);
    }


    @GetMapping("/")
    public List<Students> ListAllStudents(){
      return   studentsServices.ListAllStudents();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(@PathVariable UUID id){
       return studentsServices.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Students> editStudent(@PathVariable UUID id,@Valid @RequestBody StudentsDTO dto){
        return studentsServices.editStudent(id,dto);
    }

}
