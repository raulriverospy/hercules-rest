package py.com.hercules.seguridad.dtos;

import javax.validation.constraints.NotNull;

import com.google.common.base.MoreObjects;

public class UsuarioDTO {

    private Integer idUsuario;

    @NotNull
    private String login;

    @NotNull
    private String password;

    private boolean activo;
        
    private Integer idSanatorio;

    public UsuarioDTO() {}

    private UsuarioDTO(Integer idUsuario, 
            String login,
            String password,
            boolean activo,
            Integer idSanatorio) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.password = password;
        this.activo = activo;
        this.idSanatorio = idSanatorio;
    }

    public static class Builder {
        private Integer idUsuario;
        private String login;
        private String password;
        private boolean activo;
        private Integer idSanatorio;

        public Builder idUsuario(Integer idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder activo(boolean activo) {
            this.activo = activo;
            return this;
        }
        
   
        
        public Builder idSanatorio(Integer idSanatorio) {
            this.idSanatorio = idSanatorio;
            return this;
        }

        public UsuarioDTO build() {
            return new UsuarioDTO(idUsuario, login, password, activo, idSanatorio);
        }
    }
    
    public static Builder builder(){
        return new Builder();
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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


    public Integer getIdSanatorio() {
        return idSanatorio;
    }

    public void setIdSanatorio(Integer idSanatorio) {
        this.idSanatorio = idSanatorio;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idUsuario", idUsuario)
                .add("login", login)
                .add("password", password)
                .add("activo", activo)
                .add("idSanatorio", idSanatorio)
                .toString();
    }
    
}
