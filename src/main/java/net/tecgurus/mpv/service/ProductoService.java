package net.tecgurus.mpv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IProductoDao;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;

@Service
@RequiredArgsConstructor
public class ProductoService {
	private final IProductoDao productoDao;
	
	public List<ProductoDto> listAllUseCase(){
		return this.productoDao.listAll();
	}
	
	public List<ProductoDto> searchUseCase(String text){
		return this.productoDao.search(text);
	}
	
	public List<ProductoDto> listIn(List<Long> ids){
		return this.productoDao.listIn(ids);
	}
}
