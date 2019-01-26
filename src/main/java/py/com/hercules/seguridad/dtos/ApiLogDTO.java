package py.com.hercules.seguridad.dtos;

import java.sql.Timestamp;

public class ApiLogDTO {

    private Integer idApiLog;
    
    private String api;
    
    private String usuarioLog;
    
    private String param1;
    
    private String param2;
    
    private String param3;
    
    private Timestamp fechaLog;

    public ApiLogDTO() {}
    
    public ApiLogDTO(Integer idApiLog, String api, String usuarioLog,
            String param1, String param2, String param3, Timestamp fechaLog) {
        this.idApiLog = idApiLog;
        this.api = api;
        this.usuarioLog = usuarioLog;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.fechaLog = fechaLog;
    }

    public static class Builder {
        private Integer idApiLog;
        private String api;
        private String usuarioLog;
        private String param1;
        private String param2;
        private String param3;
        private Timestamp fechaLog;
        
        public Builder idApiLog(Integer idApiLog) {
            this.idApiLog = idApiLog;
            return this;
        }
        
        public Builder api(String api) {
            this.api = api;
            return this;
        }
        
        public Builder usuarioLog(String usuarioLog) {
            this.usuarioLog = usuarioLog;
            return this;
        }
        
        public Builder param1(String param1) {
            this.param1 = param1;
            return this;
        }
        
        public Builder param2(String param2) {
            this.param2 = param2;
            return this;
        }
        
        public Builder param3(String param3) {
            this.param3 = param3;
            return this;
        }
        
        public Builder fechaLog(Timestamp fechaLog) {
            this.fechaLog = fechaLog;
            return this;
        }
        
        public ApiLogDTO build() {
            return new ApiLogDTO(idApiLog, api, usuarioLog, param1, param2, param3, fechaLog);
        }
        
    }

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
    
    
    
    
}
