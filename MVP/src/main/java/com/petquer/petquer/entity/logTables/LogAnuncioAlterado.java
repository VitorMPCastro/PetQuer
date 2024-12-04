package com.petquer.petquer.entity.logTables;

import com.petquer.petquer.entity.Anuncio;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_anuncio_alterado")
public class LogAnuncioAlterado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_anuncio_alterado")
    private Integer idLogAnuncioAlterado;

    @Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "id_anuncio", referencedColumnName = "id_anuncio", foreignKey = @ForeignKey(name = "id_anuncio_fk"))
    private Anuncio anuncio;

    // Getters and Setters
    public Integer getIdLogAnuncioAlterado() {
        return idLogAnuncioAlterado;
    }

    public void setIdLogAnuncioAlterado(Integer idLogAnuncioAlterado) {
        this.idLogAnuncioAlterado = idLogAnuncioAlterado;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
}