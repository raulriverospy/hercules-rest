package py.com.hercules.seguridad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.hercules.common.mapper.BaseMapper;
import py.com.hercules.seguridad.dtos.PaginaDTO;
import py.com.hercules.seguridad.entities.PaginaEntity;

/**
 * @author jdferreira
 */
@Component
public class PaginaMapper implements BaseMapper<PaginaEntity, PaginaDTO> {

    private final ModelMapper modelMapper;

    public PaginaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PaginaDTO> entityListToDtoList(List<PaginaEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public PaginaDTO entityToDto(PaginaEntity entity) {
        PaginaDTO dto = modelMapper.map(entity, PaginaDTO.class);
        return dto;
    }

    @Override
    public PaginaEntity dtoToEntity(PaginaDTO dto) {
        return modelMapper.map(dto, PaginaEntity.class);
    }

}
