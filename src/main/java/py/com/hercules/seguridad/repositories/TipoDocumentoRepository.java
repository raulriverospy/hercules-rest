package py.com.hercules.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.hercules.seguridad.entities.TipoDocumentoEntity;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Integer> {

}
