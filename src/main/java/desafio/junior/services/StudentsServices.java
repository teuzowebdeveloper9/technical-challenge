package desafio.junior.services;

import desafio.junior.DTOs.RegisterDTO;
import desafio.junior.DTOs.StudentsDTO;
import desafio.junior.entitys.Registrations;
import desafio.junior.entitys.Students;
import desafio.junior.repositorys.RegistrationsRepository;
import desafio.junior.repositorys.StudentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentsServices {
    public final StudentsRepository studentsRepository;
    public  final RegistrationsRepository registrationsRepository;


    public StudentsServices(StudentsRepository studentsRepository, RegistrationsRepository registrationsRepository) {
        this.studentsRepository = studentsRepository;
        this.registrationsRepository = registrationsRepository;
    }

    public ResponseEntity<Students> createStudent(StudentsDTO dto){
        Students newStudent = new Students();

        newStudent.setBornIn(dto.BornIn());
        newStudent.setName(dto.name());
        newStudent.setTelephone(dto.telephone());

       Students savedStudent = studentsRepository.save(newStudent);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);

    }

    public Students addRegistration(RegisterDTO registerDTO){
      Students student =  studentsRepository.findById(registerDTO.studentId())
                .orElseThrow(() -> new RuntimeException("student NOT FOUND"));

      Registrations registration = registrationsRepository.findById(registerDTO.RegistrationId())
                .orElseThrow(() -> new RuntimeException("registration NOT FOUND"));

      registration.setStudent(student);
      student.getRegistrations().add(registration);

      return student;
    }

    public List<Registrations> listRegistrations(UUID id){
        Students findStudent = studentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("student NOT FOUND"));

        return findStudent.getRegistrations();
    }

    public ResponseEntity<Void> deleteStudent(UUID id){
       Students findStudent = studentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("student NOT FOUND"));

        studentsRepository.delete(findStudent);

        return ResponseEntity.notFound().build();
    }

    public Optional<Students> findById(UUID id){
      Optional<Students> student =  studentsRepository.findById(id);

        return student;
    }

    public Optional<Students> findByName(String name){
      Optional<Students> student = studentsRepository.findByName(name);

      return student;
    }

    public ResponseEntity<Students> editStudent(UUID id, StudentsDTO dto){
        Students findStudent = studentsRepository.findById(id).orElseThrow(() -> new RuntimeException("student NOT FOUND"));

        findStudent.setBornIn(dto.BornIn());
        findStudent.setName(dto.name());
        findStudent.setTelephone(dto.telephone());

        studentsRepository.save(findStudent);

        return ResponseEntity.noContent().build();
    }

    public List<Students> ListAllStudents(){
        return studentsRepository.findAll();
    }



}
