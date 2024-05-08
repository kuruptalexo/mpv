package net.tecgurus.mpv.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.tecgurus.mpv.model.dto.UsuarioDto.Perfil;

@Setter
@Getter
@Entity
@ToString
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @Column(name = "idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apaterno")
    private String aPaterno;

    @Column(name = "amaterno")
    private String aMaterno;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "perfil")
    @Enumerated(EnumType.STRING)
    private Perfil perfil;
}
