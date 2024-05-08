package net.tecgurus.mpv.model.entity.compra;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import net.tecgurus.mpv.model.entity.producto.ProductoEntity;

@Entity
@Getter
@Setter
@Table(name = "compraproducto")
public class CompraProductoEntity {
	
	@Id
	@Column(name = "idcompraproducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompraProducto;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "costo")
	private Double costo;
	
	@ManyToOne
	@JoinColumn(name = "idproducto", updatable = false)
	private ProductoEntity producto;
	
}
