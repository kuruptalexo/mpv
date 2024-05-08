package net.tecgurus.mpv.dao.jpa.producto;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.IProductoDao;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;
import net.tecgurus.mpv.model.mapper.producto.ProductoMapper;

@Repository
@RequiredArgsConstructor
public class ProductoJPADaoImpl implements IProductoDao{

	private final ProductoRepository productoRepository;
	private final ProductoMapper productoMapper;
	
	@Override
	public List<ProductoDto> listAll() {
		//el stock sea mayor a 0
		return this.productoRepository.findByStockGreaterThan(0).stream()
		.map(this.productoMapper::toDto)
		.toList();
	}

	@Override
	public List<ProductoDto> search(String search) {
		//1) stock mayor a cero
		//2) texto a buscar que coincida con el nombre o la descripcion
		//3) validar que el texto sea igual al SKU
		return this.productoRepository.search(search).stream()
				.map(this.productoMapper::toDto)
				.toList();
	}

	@Override
	public List<ProductoDto> listIn(List<Long> ids) {
		return this.productoRepository.findAllById(ids).stream()
				.map(this.productoMapper::toDto)
				.toList();
	}

	@Override
	public void updateAll(List<ProductoDto> productos) {
		// TODO Auto-generated method stub
		
	}

}
