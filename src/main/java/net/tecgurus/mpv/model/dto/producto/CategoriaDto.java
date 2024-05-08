package net.tecgurus.mpv.model.dto.producto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDto {
	
	@JsonProperty("idcategoria")
	private Long idCategoria;
	private String nombre;
	private String descripcion;
}
