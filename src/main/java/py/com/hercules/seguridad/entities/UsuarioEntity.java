package py.com.hercules.seguridad.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GenericGenerator(name = "usuarioSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "usuario_id_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "usuarioSequenceGenerator")
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotNull
    @Column(name = "login")
    private String login;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "activo")
    private boolean activo;
    
    @Column(name = "expira")
    private boolean expira;
    
    @Column(name = "fecha_expiracion")
    private LocalDate fechaExpiracion;


    @JoinColumn(name = "id_sanatorio")
    private Integer idSanatorio;

  

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdSanatorio() {
        return idSanatorio;
    }

    public void setIdSanatorio(Integer idSanatorio) {
        this.idSanatorio = idSanatorio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
   
    
    public boolean isExpira() {
        return expira;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setExpira(boolean expira) {
        this.expira = expira;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idUsuario == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UsuarioEntity toCompare = (UsuarioEntity) obj;
        return idUsuario.equals(toCompare.idUsuario);
    }

    @Override
    public int hashCode() {
        return idUsuario == null ? 0 : idUsuario.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idUsuario", idUsuario)
                .add("login", login)
                .add("password", password)
                .add("activo", activo)
                .add("idSanatorio", idSanatorio)
                .add("expira", expira)
                .add("fechaExpiracion", fechaExpiracion)
                .toString();
    }
    
}
