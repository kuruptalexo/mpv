package net.tecgurus.mpv.dao;

import java.util.List;

import net.tecgurus.mpv.model.dto.producto.ProductoDto;

public interface IProductoDao {
	List<ProductoDto> listAll();
	List<ProductoDto> search(String search);
	List<ProductoDto> listIn(List<Long> ids);
	void updateAll(List<ProductoDto> productos);
}
