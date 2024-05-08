package net.tecgurus.mpv.model.dto.compra;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import net.tecgurus.mpv.model.dto.ClienteDto;
import net.tecgurus.mpv.model.dto.UsuarioDto;

@Setter
@Getter
public class CompraDto {
	@JsonProperty("idcompra")
	private Long idCompra;
	private Double total;
	private LocalDate fecha;
	private UsuarioDto usuario;
	private ClienteDto cliente;
	private List<CompraProductoDto> productos; 
}
