package net.tecgurus.mpv.model.mapper.producto;

import org.mapstruct.Mapper;

import net.tecgurus.mpv.model.dto.producto.CategoriaDto;
import net.tecgurus.mpv.model.entity.producto.CategoriaEntity;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
	CategoriaDto toDto(CategoriaEntity entity);
	CategoriaEntity toEntity(CategoriaDto dto);
}
