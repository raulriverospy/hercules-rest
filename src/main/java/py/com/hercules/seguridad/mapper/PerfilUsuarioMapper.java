package py.com.hercules.seguridad.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import py.com.hercules.common.mapper.BaseMapper;
import py.com.hercules.seguridad.dtos.PerfilUsuarioDTO;
import py.com.hercules.seguridad.entities.PerfilUsuarioEntity;

/**
 * @author jdferreira
 */
@Component
public class PerfilUsuarioMapper implements BaseMapper<PerfilUsuarioEntity, PerfilUsuarioDTO> {

    private final ModelMapper modelMapper;

    public PerfilUsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PerfilUsuarioDTO> entityListToDtoList(List<PerfilUsuarioEntity> entityList) {
        return entityList.stream().filter(Objects::nonNull)
                .map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public PerfilUsuarioDTO entityToDto(PerfilUsuarioEntity entity) {
        PerfilUsuarioDTO dto = modelMapper.map(entity, PerfilUsuarioDTO.class);
        return dto;
    }

    @Override
    public PerfilUsuarioEntity dtoToEntity(PerfilUsuarioDTO dto) {
        return modelMapper.map(dto, PerfilUsuarioEntity.class);
    }

}
