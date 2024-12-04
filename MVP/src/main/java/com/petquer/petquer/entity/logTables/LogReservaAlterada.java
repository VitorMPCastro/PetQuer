package com.petquer.petquer.entity.logTables;

import com.petquer.petquer.entity.Reserva;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_reserva_alterada")
public class LogReservaAlterada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_reserva_alterada")
    private Integer idLogReservaAlterada;

    @Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva", foreignKey = @ForeignKey(name = "id_reserva_fk"))
    private Reserva reserva;

    // Getters and Setters
    public Integer getIdLogReservaAlterada() {
        return idLogReservaAlterada;
    }

    public void setIdLogReservaAlterada(Integer idLogReservaAlterada) {
        this.idLogReservaAlterada = idLogReservaAlterada;
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