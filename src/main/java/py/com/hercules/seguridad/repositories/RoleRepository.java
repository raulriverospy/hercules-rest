package py.com.hercules.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.hercules.seguridad.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

}
