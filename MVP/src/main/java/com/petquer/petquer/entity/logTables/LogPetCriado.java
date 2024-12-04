// LogPetCriado.java
package com.petquer.petquer.entity.logTables;

import com.petquer.petquer.entity.Pet;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_pet_criado")
public class LogPetCriado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_pet_criado")
    private Integer idLogPetCriado;

    @Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "id_pet", referencedColumnName = "id_pet", foreignKey = @ForeignKey(name = "log_pet_criado_id_pet_fk"))
    private Pet pet;

    // Getters and Setters
    public Integer getIdLogPetCriado() {
        return idLogPetCriado;
    }

    public void setIdLogPetCriado(Integer idLogPetCriado) {
        this.idLogPetCriado = idLogPetCriado;
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