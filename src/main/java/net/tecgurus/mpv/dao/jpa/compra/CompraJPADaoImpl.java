package net.tecgurus.mpv.dao.jpa.compra;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import net.tecgurus.mpv.dao.ICompraDao;
import net.tecgurus.mpv.model.dto.compra.CompraDto;
import net.tecgurus.mpv.model.entity.compra.CompraEntity;
import net.tecgurus.mpv.model.mapper.compra.CompraMapper;

@Repository
@RequiredArgsConstructor
public class CompraJPADaoImpl implements ICompraDao{
	
	private final CompraRepository compraRepository;
	private final CompraMapper compraMapper;

	@Override
	public void create(CompraDto compra) {
		CompraEntity entity = this.compraMapper.toEntity(compra);
		this.compraRepository.save(entity);
		compra.setIdCompra(entity.getIdCompra());
	}

	@Override
	public List<CompraDto> listAll() {
		return this.compraRepository.findAll().stream()
			//.map( compraEntity -> this.compraMapper.toDto(compraEntity))
			.map(this.compraMapper::toDto)
			.toList();
	}

	@Override
	public CompraDto getById(Long id) {
		CompraEntity entity = this.compraRepository.getReferenceById(id);
		return this.compraMapper.toDto(entity);
	}

}
