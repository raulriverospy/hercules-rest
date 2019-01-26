package py.com.hercules.seguridad.services.impl;

import java.util.List;

import javax.naming.NamingException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.hercules.common.BaseServiceImpl;
import py.com.hercules.common.Constantes;
import py.com.hercules.exceptions.InternalServerErrorException;
import py.com.hercules.exceptions.UnauthorizedException;
import py.com.hercules.seguridad.dtos.UsuarioDTO;
import py.com.hercules.seguridad.entities.RoleEntity;
import py.com.hercules.seguridad.entities.UsuarioEntity;
import py.com.hercules.seguridad.entities.UsuarioRoleEntity;
import py.com.hercules.seguridad.mapper.UsuarioMapper;
import py.com.hercules.seguridad.repositories.RoleRepository;
import py.com.hercules.seguridad.repositories.UsuarioRepository;
import py.com.hercules.seguridad.repositories.UsuarioRoleRepository;
import py.com.hercules.seguridad.services.UsuarioService;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepo;

    private final UsuarioMapper usuarioMapper;
    
    private final UsuarioRoleRepository usuarioRoleRepo;
    
    private final RoleRepository roleRepo;

    
    public UsuarioServiceImpl(
            UsuarioRepository usuarioRepo,
            UsuarioMapper usuarioMapper,
            UsuarioRoleRepository usuarioRoleRepo,
            RoleRepository roleRepo) throws NamingException {
        this.usuarioRepo = usuarioRepo;
        this.usuarioMapper = usuarioMapper;
        this.usuarioRoleRepo = usuarioRoleRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public void grabarUsuario(UsuarioDTO usuario) {
        usuario.setPassword(Constantes.getTemporalPass());
        usuario.setActivo(true);        
        UsuarioEntity u = usuarioRepo.save(usuarioMapper.dtoToEntity(usuario));
        
        RoleEntity roleUser = roleRepo.getOne(1);
        RoleEntity roleAdmin = roleRepo.getOne(2);
        
        UsuarioRoleEntity uRoleUser = new UsuarioRoleEntity();
        uRoleUser.setRoles(roleUser);
        uRoleUser.setUsuario(u);
        
        usuarioRoleRepo.save(uRoleUser);
        
        UsuarioRoleEntity uRoleAdmin = new UsuarioRoleEntity();
        uRoleAdmin.setRoles(roleAdmin);
        uRoleAdmin.setUsuario(u);
        
        usuarioRoleRepo.save(uRoleAdmin);
        
    }

    @Override
    public UsuarioDTO findByLogin(String login) {
        
        UsuarioEntity usuarioEntity = usuarioRepo.findByLogin(login);
        
        if (usuarioEntity != null) {
            return usuarioMapper.entityToDto(usuarioEntity);
        }else{
            return null;
        }
        
        
    }

    @Override
    public Page<UsuarioDTO> findAllPageable(Pageable pageable) {
        Page<UsuarioEntity> pageResponse = usuarioRepo.findAll(pageable);
        return pageResponse.map(usuarioMapper::entityToDto);
    }

    @Override
    public String cambiarPassword(String username, String oldPassword,
            String newPassword) {
        // TODO Auto-generated method stub
        try {
            System.out.println(oldPassword);
            System.out.println(newPassword);
            UsuarioEntity u = usuarioRepo.findByLogin(username);
            if(checkHashPassword(u.getPassword(), oldPassword)){
                u.setPassword(getHashPassword(newPassword));
                usuarioRepo.save(u);
                return "¡Contraseña actualizada correctamente!";
                
            }else{
                throw new UnauthorizedException("No coinicide con su pass anterior");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new InternalServerErrorException("¡Ha ocurrido un error!");
        }
    }

    @Override
    public boolean verificarPassword(String username, String password) {
        try {
            UsuarioEntity u = usuarioRepo.findByLogin(username);
            return checkHashPassword(u.getPassword(), password);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new InternalServerErrorException("¡Ha ocurrido un error!");
        }
    }

    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioMapper.entityListToDtoList((List<UsuarioEntity>) usuarioRepo.findAll());
    }

    @Override
    public UsuarioDTO findById(Integer idUsuario) {
        
        UsuarioEntity usuarioEntity = usuarioRepo.findByIdUsuario(idUsuario);
        
        if (usuarioEntity != null) {
            return usuarioMapper.entityToDto(usuarioEntity);
        }else{
            return null;
        }
        
    }

}
