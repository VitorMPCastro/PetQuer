// LogUsuarioCriado.java
package com.petquer.petquer.entity.logTables;

import com.petquer.petquer.entity.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_usuario_criado")
public class LogUsuarioCriado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_usuario_criado")
    private Integer idLogUsuarioCriado;

    @Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", foreignKey = @ForeignKey(name = "log_usuario_criado_id_usuario_fk"))
    private User usuario;

    // Getters and Setters
    public Integer getIdLogUsuarioCriado() {
        return idLogUsuarioCriado;
    }

    public void setIdLogUsuarioCriado(Integer idLogUsuarioCriado) {
        this.idLogUsuarioCriado = idLogUsuarioCriado;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}