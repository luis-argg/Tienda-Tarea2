package com.luisargueta.tiendafrontend.entity;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@JsonPropertyOrder({
        "idUsuario",
        "nombreUsuario",
        "apellidoUsuario",
        "edadUsuario",
        "username",
        "password"
})

@Entity
@Table(name = "usuario")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @NotBlank(message = "El nombre del usuario no puede ir vacio.")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres.")
    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;

    @NotBlank(message = "El apellido del usuario no puede ir vacio.")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres.")
    @Column(name = "apellido_usuario", nullable = false)
    private String apellidoUsuario;

    @NotNull(message = "La edad no puede ir vacia.")
    @Min(value = 1, message = "La edad debe ser mayor o igual a 1.")
    @Max(value = 120, message = "La edad debe ser menor o igual a 120.")
    @Column(name = "edad_usuario", nullable = false)
    private Integer edadUsuario;

    @NotBlank(message = "El nombre de usuario no puede ir vacio")
    @Size(min = 2, message = "El nombre de usuario debe ser mayor a 1.")
    @Column(name = "user_name", updatable = false)
    private String username;

    @NotBlank(message = "La contraseña no puede ir vacia")
    @Size(min = 6, max = 100, message = "La contraseña debe tener entre 6 y 100 caracteres")
    @Column(name = "password", updatable = false)
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public Integer getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(Integer edadUsuario) {
        this.edadUsuario = edadUsuario;
    }
}
