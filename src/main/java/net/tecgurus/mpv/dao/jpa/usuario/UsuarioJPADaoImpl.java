package net.tecgurus.mpv.dao.jpa.usuario;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IUsuarioDao;
import net.tecgurus.mpv.model.dto.UsuarioDto;
import net.tecgurus.mpv.model.entity.UsuarioEntity;
import net.tecgurus.mpv.model.mapper.UsuarioMapper;

@Repository
@RequiredArgsConstructor
public class UsuarioJPADaoImpl implements IUsuarioDao {

	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper usuarioMapper;

	@Override
	public void create(UsuarioDto usuario) {
		UsuarioEntity entity = usuarioMapper.toEntity(usuario);
		this.usuarioRepository.save(entity);
		usuario.setIdUsuario(entity.getIdUsuario());
	}
	
	public List<UsuarioDto> listAll(){
		return this.usuarioRepository.findAll().stream()
				//.map(entity -> this.usuarioMapper.toDto(entity))
				.map(this.usuarioMapper::toDto)
				.toList();
	}

}
