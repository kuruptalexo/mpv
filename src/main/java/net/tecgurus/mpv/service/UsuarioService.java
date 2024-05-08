package net.tecgurus.mpv.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IUsuarioDao;
import net.tecgurus.mpv.model.dto.UsuarioDto;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final IUsuarioDao usuarioDao;

	public void signup(UsuarioDto usuario) {
		this.usuarioDao.create(usuario);
	}

}
