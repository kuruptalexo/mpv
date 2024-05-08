package net.tecgurus.mpv.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.model.dto.UsuarioDto;
import net.tecgurus.mpv.service.UsuarioService;

@RestController
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	@PostMapping("/usuario")
	public ResponseEntity<UsuarioDto> signup(@RequestBody UsuarioDto usuario){
		this.usuarioService.signup(usuario);
		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	}

}
