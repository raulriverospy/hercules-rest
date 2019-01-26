package py.com.hercules.seguridad.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.hercules.seguridad.dtos.TipoDocumentoDTO;
import py.com.hercules.seguridad.mapper.TipoDocumentoMapper;
import py.com.hercules.seguridad.repositories.TipoDocumentoRepository;
import py.com.hercules.seguridad.services.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
	private TipoDocumentoMapper tipoDocumentoMapper;
	
	@Override
	public TipoDocumentoDTO grabarTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<TipoDocumentoDTO> tipoDocumentoAll(TipoDocumentoDTO tipoDocumento) {
		
		return tipoDocumentoMapper.entityListToDtoList(tipoDocumentoRepository.findAll());
		
	}

	
	
}
