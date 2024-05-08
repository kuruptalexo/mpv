package net.tecgurus.mpv.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import net.tecgurus.mpv.model.dto.UsuarioDto;
import net.tecgurus.mpv.model.entity.UsuarioEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {
    UsuarioDto toDto(UsuarioEntity entity);

    UsuarioEntity toEntity(UsuarioDto dto);

    @Named(value = "resume")
    @Mapping(target = "password", ignore = true)
    UsuarioDto toUsuarioSummary(UsuarioEntity entity);
}
