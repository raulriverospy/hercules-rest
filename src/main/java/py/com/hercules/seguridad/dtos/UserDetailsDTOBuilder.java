package py.com.hercules.seguridad.dtos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class UserDetailsDTOBuilder {
    private String username;
    private String password;
    private boolean enabled;
    private List<GrantedAuthority> grantedAuthorities;
    private boolean expira;
    private LocalDate fechaExpiracion;
    
    public UserDetailsDTOBuilder username(String username) {
        this.username = username;
        return this;
    }

    public UserDetailsDTOBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserDetailsDTOBuilder enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public UserDetailsDTOBuilder grantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
        return this;
    }
    
    public UserDetailsDTOBuilder expira(boolean expira){
        this.expira = expira;
        return this;
    }
    
    public UserDetailsDTOBuilder fechaExpiracion(LocalDate fechaExpiracion){
        this.fechaExpiracion = fechaExpiracion;
        return this;
    }

    
    public UserDetailsDTO build() {
        return new UserDetailsDTO(username,
                password,
                enabled,
                grantedAuthorities,
                expira,
                fechaExpiracion);
    }
}