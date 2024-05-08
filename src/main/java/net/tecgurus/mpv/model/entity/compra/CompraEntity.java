package net.tecgurus.mpv.model.entity.compra;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import net.tecgurus.mpv.model.entity.ClienteEntity;
import net.tecgurus.mpv.model.entity.UsuarioEntity;

@Entity
@Getter
@Setter
@Table(name = "compra")
public class CompraEntity {
	
	@Id
	@Column(name = "idcompra")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompra;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name = "idcliente")
	private ClienteEntity cliente;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idcompra")
	private List<CompraProductoEntity> productos; 

}
