package net.tecgurus.mpv.dao;

import java.util.List;

import net.tecgurus.mpv.model.dto.compra.CompraDto;

public interface ICompraDao {
	void create(CompraDto compra);
	List<CompraDto> listAll();
	CompraDto getById(Long id);
}
