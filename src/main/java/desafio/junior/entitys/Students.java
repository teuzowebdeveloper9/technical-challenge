package desafio.junior.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "students")
public class Students  extends baseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private Integer telephone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate BornIn;

    public Students() {
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Registrations>  registrations;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public LocalDate getBornIn() {
        return BornIn;
    }

    public void setBornIn(LocalDate bornIn) {
        BornIn = bornIn;
    }

    public List<Registrations> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registrations> registrations) {
        this.registrations = registrations;
    }
}
