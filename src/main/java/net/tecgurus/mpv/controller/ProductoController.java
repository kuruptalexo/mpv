package net.tecgurus.mpv.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;
import net.tecgurus.mpv.service.ProductoService;

@RestController
@RequiredArgsConstructor
public class ProductoController {
	private final ProductoService productoService;
	
	@GetMapping("/producto")
	public ResponseEntity<List<ProductoDto>> listAll(){
		List<ProductoDto> productos = this.productoService.listAllUseCase();
		return ResponseEntity.ok(productos);
	}
	
	@GetMapping("/producto/busqueda/{param}")
	public ResponseEntity<List<ProductoDto>> search(@PathVariable String param){
		List<ProductoDto> productos = this.productoService.searchUseCase(param);
		return ResponseEntity.ok(productos);
	}
}
