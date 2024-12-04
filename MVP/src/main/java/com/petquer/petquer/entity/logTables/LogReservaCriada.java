// LogReservaCriada.java
package com.petquer.petquer.entity.logTables;

import com.petquer.petquer.entity.Reserva;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_reserva_criada")
public class LogReservaCriada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_reserva_criada")
    private Integer idLogReservaCriada;

    @Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", foreignKey = @ForeignKey(name = "log_reserva_criada_id_reserva_fk"))
    private Reserva reserva;

    // Getters and Setters
    public Integer getIdLogReservaCriada() {
        return idLogReservaCriada;
    }

    public void setIdLogReservaCriada(Integer idLogReservaCriada) {
        this.idLogReservaCriada = idLogReservaCriada;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}