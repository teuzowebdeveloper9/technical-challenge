package desafio.junior.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private Integer telephone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate BornIn;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate untilIn;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedIn;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Registrations>  registrations;

}
