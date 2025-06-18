package desafio.junior.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "registrations")
public class Registrations extends baseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeRegistration;

    private String course;

    private LocalDate startIn;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students student;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getCodeRegistration() {
        return codeRegistration;
    }

    public void setCodeRegistration(Long codeRegistration) {
        this.codeRegistration = codeRegistration;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public LocalDate getStartIn() {
        return startIn;
    }

    public void setStartIn(LocalDate startIn) {
        this.startIn = startIn;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }
}
