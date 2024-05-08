package net.tecgurus.mpv.service.compra;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.exception.NotEnoughStock;
import net.tecgurus.mpv.model.dto.compra.CompraDto;
import net.tecgurus.mpv.model.dto.compra.CompraProductoDto;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;
import net.tecgurus.mpv.service.ProductoService;

@Service
@RequiredArgsConstructor
public class CompraService {
	
	private final ProductoService productoService;
	
	public CompraDto makePurchaseUseCase(CompraDto compra) {
		//Validate stock
		boolean hasAvailableStock = this.hasEnoughStock(compra);
		if(!hasAvailableStock) {
			throw new NotEnoughStock("The stock is not Enough");
		}
		
		//Set purchase date
		//Calculate total by product
		//Calculate total of purchase
		//Save the current data of purchase
		//Update product stock
		//Update compra entity
		return null;
	}
	
	public boolean hasEnoughStock(CompraDto compra) {
		//Generate a list of the products ids
		List<Long> ids = compra.getProductos().stream()
				.map(cp -> cp.getProducto().getIdProducto())
				.toList();
		
		//Getting the current info of the products on db
		List<ProductoDto> productsFromDb = this.productoService.listIn(ids);
		
		Map<Long, ProductoDto> currentProductsMap = productsFromDb.stream()
				.collect(
					Collectors.toMap(
						producto -> producto.getIdProducto(),
						producto ->  producto
					)
				);
		
		for(CompraProductoDto compraProducto : compra.getProductos()) {
			long idProductoOnCompra = compraProducto.getProducto().getIdProducto();
			compraProducto.setProducto(currentProductsMap.get(idProductoOnCompra));
			
			int purchaseAmount = compraProducto.getCantidad();
			boolean sold = purchaseAmount > compraProducto.getProducto().getStock();
			if(sold) return false;
		}
		
		return true;
	}
}
