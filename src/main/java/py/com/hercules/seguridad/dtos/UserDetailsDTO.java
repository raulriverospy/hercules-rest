package py.com.hercules.seguridad.dtos;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by jdferreira on 10/09/18.
 */
public class UserDetailsDTO implements UserDetails {

    private final String password;
    private final  String username;
    private final boolean enabled;
    private final List<GrantedAuthority> grantedAuthorities;
    private final boolean expira;
    private final LocalDate fechaExpiracion;

    UserDetailsDTO(String username,
            String password,
            boolean enabled,
            List<GrantedAuthority> grantedAuthorities,
            boolean expira,
            LocalDate fechaExpiracion) {
        this.password = password;
        this.username = username;
        this.enabled = enabled;
        this.grantedAuthorities = grantedAuthorities;
        this.expira = expira;
        this.fechaExpiracion = fechaExpiracion;
    }

    public static UserDetailsDTOBuilder builder() {
        return new UserDetailsDTOBuilder();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    
    public List<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public boolean isExpira() {
        return expira;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // we never lock accounts
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // credentials never expire
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
   
}
