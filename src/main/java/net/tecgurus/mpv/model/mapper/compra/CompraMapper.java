package net.tecgurus.mpv.model.mapper.compra;

import org.mapstruct.Mapper;

import net.tecgurus.mpv.model.dto.compra.CompraDto;
import net.tecgurus.mpv.model.entity.compra.CompraEntity;
import net.tecgurus.mpv.model.mapper.ClienteMapper;
import net.tecgurus.mpv.model.mapper.UsuarioMapper;

@Mapper(
	componentModel = "spring",
	uses = {
		UsuarioMapper.class, 
		ClienteMapper.class,
		CompraProductoMapper.class
	}
)
public interface CompraMapper {
	CompraDto toDto(CompraEntity entity);
	CompraEntity toEntity(CompraDto dto);
}
