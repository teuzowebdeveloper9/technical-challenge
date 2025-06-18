package desafio.junior.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "registrations")
public class Registrations {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeRegistration;

    private String course;

    private LocalDate startIn;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate untilIn;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedIn;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students student;

}
