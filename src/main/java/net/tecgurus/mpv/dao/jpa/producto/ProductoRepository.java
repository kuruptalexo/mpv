package net.tecgurus.mpv.dao.jpa.producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.tecgurus.mpv.model.entity.producto.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
	
	@Query(value = 
			"""
			SELECT p FROM ProductoEntity p 
			WHERE (p.stock > 0) and
			( 
				p.descripcion like concat('%',:text,'%') or 
				p.nombre like concat('%',:text,'%') or
				p.sku = :text
			)
			"""
	)		
	List<ProductoEntity> search(@Param("text") String text);
	
	List<ProductoEntity> findByStockGreaterThan(Integer stock);
	
}
