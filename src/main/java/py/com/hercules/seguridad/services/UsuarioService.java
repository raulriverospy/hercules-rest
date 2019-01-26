package py.com.hercules.seguridad.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.hercules.seguridad.dtos.UsuarioDTO;

public interface UsuarioService {

    void grabarUsuario(UsuarioDTO usuario);
    
    UsuarioDTO findByLogin(String login);
    
    UsuarioDTO findById(Integer idUsuario);
    
    Page<UsuarioDTO> findAllPageable(Pageable pageable);
    
    List<UsuarioDTO> findAll();
    
    String cambiarPassword(String username , String oldPassword, String newPassword);
    
    boolean verificarPassword(String username ,String password);
    
}
