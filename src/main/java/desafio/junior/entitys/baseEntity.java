package desafio.junior.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class baseEntity {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate untilIn;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedIn;

    @PrePersist
    public void onCreate() {
        if (this.untilIn == null) {
            this.untilIn = LocalDate.now();
        }
        this.updatedIn = LocalDate.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedIn = LocalDate.now();
    }

    public LocalDate getUntilIn() {
        return untilIn;
    }

    public void setUntilIn(LocalDate untilIn) {
        this.untilIn = untilIn;
    }

    public LocalDate getUpdatedIn() {
        return updatedIn;
    }

    public void setUpdatedIn(LocalDate updatedIn) {
        this.updatedIn = updatedIn;
    }
}
