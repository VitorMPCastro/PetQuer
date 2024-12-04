// LogPetAlterado.java
package com.petquer.petquer.entity.logTables;

import com.petquer.petquer.entity.Pet;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_pet_alterado")
public class LogPetAlterado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_pet_alterado")
    private Integer idLogPetAlterado;

    @Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "id_pet", referencedColumnName = "id_pet", foreignKey = @ForeignKey(name = "id_pet_fk"))
    private Pet pet;

    // Getters and Setters
    public Integer getIdLogPetAlterado() {
        return idLogPetAlterado;
    }

    public void setIdLogPetAlterado(Integer idLogPetAlterado) {
        this.idLogPetAlterado = idLogPetAlterado;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}