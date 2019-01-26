package py.com.hercules.seguridad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.hercules.common.mapper.BaseMapper;
import py.com.hercules.seguridad.dtos.ApiLogDTO;
import py.com.hercules.seguridad.entities.ApiLogEntity;

/**
 * @author jdferreira
 */
@Component
public class ApiLogMapper implements BaseMapper<ApiLogEntity, ApiLogDTO> {

    private final ModelMapper modelMapper;

    public ApiLogMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ApiLogDTO> entityListToDtoList(List<ApiLogEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull).map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public ApiLogDTO entityToDto(ApiLogEntity entity) {
        ApiLogDTO dto = modelMapper.map(entity, ApiLogDTO.class);
        return dto;
    }

    @Override
    public ApiLogEntity dtoToEntity(ApiLogDTO dto) {
        return modelMapper.map(dto, ApiLogEntity.class);
    }
}
