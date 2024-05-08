package net.tecgurus.mpv.model.mapper.producto;

import org.mapstruct.Mapper;

import net.tecgurus.mpv.model.dto.producto.ProductoDto;
import net.tecgurus.mpv.model.entity.producto.ProductoEntity;

@Mapper(
	componentModel = "spring",
	uses = {CategoriaMapper.class}
)
public interface ProductoMapper {
	ProductoDto toDto(ProductoEntity entity);
	ProductoEntity toEntity(ProductoDto dto);
}
