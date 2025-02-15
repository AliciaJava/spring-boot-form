package com.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

//import javax.validation.Valid;
import javax.validation.constraints.Email;
//import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.springboot.form.app.validation.IdentificadorRegex;
import com.springboot.form.app.validation.Requerido;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
	
	//@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdentificadorRegex
	private String identificador;
	
	//@NotEmpty(message = "el nombre no puede ser vacio")
	private String nombre;
	
	//@NotEmpty
	@Requerido
	private String apellido;

	@NotBlank
	@Size(min = 3, max=8)
	private String username;
	
	@NotEmpty
	private String password;
	
	@Requerido
	@Email(message = "correo con formato incorrecto")
	private String email;
	
	@NotNull
	@Min(5)
	@Max(5000)
	private Integer cuenta;
	
	@NotNull
	@Past
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@NotNull
	private Pais pais;
	
	@NotEmpty
	private List<Role> roles;
	
	private Boolean habilitar;
	
	@NotEmpty
	private String genero;
	
	private String valorSecreto;

}
