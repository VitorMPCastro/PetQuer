// LogUsuarioAlterado.java
package com.petquer.petquer.entity.logTables;

import com.petquer.petquer.entity.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_usuario_alterado")
public class LogUsuarioAlterado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_usuario_alterado")
    private Integer idLogUsuarioAlterado;

    @Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", foreignKey = @ForeignKey(name = "log_usuario_alterado_id_usuario_fk"))
    private User usuario;

    // Getters and Setters
    public Integer getIdLogUsuarioAlterado() {
        return idLogUsuarioAlterado;
    }

    public void setIdLogUsuarioAlterado(Integer idLogUsuarioAlterado) {
        this.idLogUsuarioAlterado = idLogUsuarioAlterado;
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