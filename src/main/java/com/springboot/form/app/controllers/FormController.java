package com.springboot.form.app.controllers;

import com.springboot.form.app.editors.NombreMayusculaEditor;
import com.springboot.form.app.editors.PaisPropertyEditor;
import com.springboot.form.app.editors.RolesEditor;
import com.springboot.form.app.models.domain.Pais;
import com.springboot.form.app.models.domain.Role;
import com.springboot.form.app.models.domain.Usuario;
import com.springboot.form.app.services.PaisService;
import com.springboot.form.app.services.RoleService;
import com.springboot.form.app.validation.UsuarioValidador;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("usuario")
@RequiredArgsConstructor
public class FormController {

	private static final String TITULO = "titulo";
	private final UsuarioValidador validador;
	private final PaisService paisService;
	private final RoleService roleService;
	private final NombreMayusculaEditor nombreMayusculaEditor;
	private final PaisPropertyEditor paisEditor;
	private final RolesEditor roleEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true));

		binder.registerCustomEditor(String.class, "nombre", nombreMayusculaEditor);
		binder.registerCustomEditor(String.class, "apellido", nombreMayusculaEditor);
		
		binder.registerCustomEditor(Pais.class, "pais", paisEditor);
		binder.registerCustomEditor(Role.class, "roles", roleEditor);
	}
	
	@ModelAttribute("genero")
	public List<String> genero(){
		return Arrays.asList("Hombre", "Mujer");
	}
	
	@ModelAttribute("listaRoles")
	public List<Role> listaRoles(){
		return this.roleService.listar();
	}

	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
		return paisService.listar();
	}

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("John");
		usuario.setApellido("Doe");
		usuario.setIdentificador("12.456.789-K");
		usuario.setHabilitar(true);
		usuario.setValorSecreto("Algún valor secreto ****");
		usuario.setPais(listaPaises().get(2));
		usuario.setRoles(List.of(listaRoles().get(1)));
		
		model.addAttribute(TITULO, "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute(TITULO, "Resultado form");
			return "form";
		}
		
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name="usuario", required = false) Usuario usuario, Model model, SessionStatus status) {
		
		if(usuario == null) {
			return "redirect:/form";
		}
		
		model.addAttribute(TITULO, "Resultado form");
		
		status.setComplete();
		return "resultado";
	}

}
