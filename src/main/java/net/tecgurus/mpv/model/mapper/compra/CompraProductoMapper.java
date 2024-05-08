package net.tecgurus.mpv.model.mapper.compra;

import org.mapstruct.Mapper;

import net.tecgurus.mpv.model.dto.compra.CompraProductoDto;
import net.tecgurus.mpv.model.entity.compra.CompraProductoEntity;
import net.tecgurus.mpv.model.mapper.producto.ProductoMapper;

@Mapper(
	componentModel = "spring",
	uses = {ProductoMapper.class}
)
public interface CompraProductoMapper {
	CompraProductoDto toDto(CompraProductoEntity entity);
	CompraProductoEntity toEntity(CompraProductoDto dto);
}
