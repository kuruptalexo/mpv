package net.tecgurus.mpv.dao.jpa.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import net.tecgurus.mpv.model.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
