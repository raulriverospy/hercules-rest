package py.com.hercules.seguridad.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import py.com.hercules.seguridad.entities.UsuarioEntity;

/**
 * @author jdferreira
 */
public interface UsuarioRepository
        extends PagingAndSortingRepository<UsuarioEntity, Long>  {
    UsuarioEntity findByLogin(String login);
    
    UsuarioEntity findByIdUsuario(Integer idUsuario);
}
