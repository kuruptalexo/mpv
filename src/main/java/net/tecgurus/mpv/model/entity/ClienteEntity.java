package net.tecgurus.mpv.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cliente")
public class ClienteEntity {
	
	@Id
	@Column(name = "idcliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apaterno")
	private String aPaterno;
	
	@Column(name = "amaterno")
	private String aMaterno;
	
	@Column(name = "rfc")
	private String rfc;
	
}
