package py.com.hercules.seguridad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.hercules.seguridad.entities.ApiLogEntity;

public interface ApiLogRepository extends JpaRepository<ApiLogEntity, Integer> {
    
    List<ApiLogEntity> findByApi(String api);

    <S extends ApiLogEntity> S save(ApiLogEntity apiLogEntity );
}
