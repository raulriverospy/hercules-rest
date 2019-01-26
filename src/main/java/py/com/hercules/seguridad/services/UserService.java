package py.com.hercules.seguridad.services;

import java.util.List;

import py.com.hercules.seguridad.dtos.UsuarioDTO;

public interface UserService {

    UsuarioDTO updateUser(Long userId, UsuarioDTO user);

    UsuarioDTO addUser(UsuarioDTO user);

    UsuarioDTO getUserById(Long userId);

    List<UsuarioDTO> getAllUsers();

    void deleteUser(Long userId);

}