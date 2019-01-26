package py.com.hercules.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.hercules.seguridad.entities.UsuarioRoleEntity;

public interface UsuarioRoleRepository  extends JpaRepository<UsuarioRoleEntity, Integer> {
    
}
