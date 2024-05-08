package net.tecgurus.mpv.model.mapper;

import org.mapstruct.Mapper;

import net.tecgurus.mpv.model.dto.ClienteDto;
import net.tecgurus.mpv.model.entity.ClienteEntity;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	ClienteDto toDto(ClienteEntity entity);
	ClienteEntity toEntity(ClienteDto dto);
}
