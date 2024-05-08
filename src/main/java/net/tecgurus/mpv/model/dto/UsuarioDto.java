package net.tecgurus.mpv.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"idusuario"})
public class UsuarioDto {
    @JsonProperty("idusuario")
    private Long idUsuario;

    private String email;

    private String password;

    private String nombre;

    @JsonProperty("apaterno")
    private String aPaterno;

    @JsonProperty("amaterno")
    private String aMaterno;

    private Boolean activo;

    private Perfil perfil;

    public enum Perfil {
        ROLE_ADMIN,
        ROLE_USER
    }
}
