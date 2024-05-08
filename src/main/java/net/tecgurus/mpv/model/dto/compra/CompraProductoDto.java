package net.tecgurus.mpv.model.dto.compra;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import net.tecgurus.mpv.model.dto.producto.ProductoDto;

@Getter
@Setter
public class CompraProductoDto {
	@JsonProperty("idcompraproducto")
	private Long idCompraProducto;
	private Integer cantidad;
	private Double costo;
	private ProductoDto producto;
}
