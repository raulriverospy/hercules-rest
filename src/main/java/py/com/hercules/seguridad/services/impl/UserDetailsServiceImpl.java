package py.com.hercules.seguridad.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import py.com.hercules.seguridad.dao.UsuarioDAO;
import py.com.hercules.seguridad.dao.UsuarioRoleDAO;
import py.com.hercules.seguridad.dtos.UserDetailsDTO;
import py.com.hercules.seguridad.entities.ApiLogEntity;
import py.com.hercules.seguridad.entities.UsuarioEntity;
import py.com.hercules.seguridad.repositories.ApiLogRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UsuarioDAO appUserDAO;
 
    @Autowired
    private UsuarioRoleDAO appRoleDAO;
    
    @Autowired
    ApiLogRepository apiLogRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UsuarioEntity appUser = this.appUserDAO.findUserAccount(userName);
 
        if (appUser == null) {
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.appRoleDAO.getRoleNames(appUser.getIdUsuario());
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        
        //guardar en apilog el login
        ApiLogEntity log = new ApiLogEntity();
        log.setApi("LOGIN");
        log.setUsuarioLog(appUser.getLogin());
        apiLogRepository.save(log);
        
        return UserDetailsDTO.builder()
        .username(appUser.getLogin())
        .password(appUser.getPassword())
        .enabled(appUser.isActivo())
        .grantedAuthorities(this.getGrantedAuthorities(grantList))
        .expira(appUser.isExpira())
        .fechaExpiracion(appUser.getFechaExpiracion())
        .build();
        
    }
    
    private List<GrantedAuthority> getGrantedAuthorities(List<GrantedAuthority> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (GrantedAuthority role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }
        return authorities;
    }
 
}