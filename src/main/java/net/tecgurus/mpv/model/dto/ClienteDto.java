package net.tecgurus.mpv.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteDto {
	@JsonProperty("idcliente")
	private Long idCliente;
	private String nombre;
	@JsonProperty("apaterno")
	private String aPaterno;
	@JsonProperty("amaterno")
	private String aMaterno;
	private String rfc;
}
