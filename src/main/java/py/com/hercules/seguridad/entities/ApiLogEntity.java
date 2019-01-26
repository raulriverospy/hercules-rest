package py.com.hercules.seguridad.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "api_log")
public class ApiLogEntity {
    
    @Id
    @GenericGenerator(name = "apiLogSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "api_log_id_api_log_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "apiLogSequenceGenerator")
    @Column(name = "id_api_log")
    private Integer idApiLog;
    
    @NotNull
    @Column(name = "api")
    private String api;
    
    @Column(name = "usuariolog")
    private String usuarioLog;
    
    @Column(name = "param1")
    private String param1;
    
    @Column(name = "param2")
    private String param2;
    
    @Column(name = "param3")
    private String param3;
    
    @Column(name = "fechalog")
    private Timestamp fechaLog;

    public Integer getIdApiLog() {
        return idApiLog;
    }

    public void setIdApiLog(Integer idApiLog) {
        this.idApiLog = idApiLog;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(String usuarioLog) {
        this.usuarioLog = usuarioLog;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public Timestamp getFechaLog() {
        return fechaLog;
    }

    public void setFechaLog(Timestamp fechaLog) {
        this.fechaLog = fechaLog;
    }
   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idApiLog == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApiLogEntity toCompare = (ApiLogEntity) obj;
        return idApiLog.equals(toCompare.idApiLog);
    }

    @Override
    public int hashCode() {
        return idApiLog == null ? 0 : idApiLog.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idApiLog", idApiLog)
                .add("api", api)
                .add("param1", param1)
                .add("param2", param2)
                .add("param3", param3)
                .add("usuarioLog", usuarioLog)
                .add("fechaLog", fechaLog)
                .toString();
    }
    
    
    @PrePersist
    public void preSave() {
        this.fechaLog = new Timestamp(System.currentTimeMillis());
    }    

}
