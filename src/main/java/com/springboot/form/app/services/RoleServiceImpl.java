package com.springboot.form.app.services;

import com.springboot.form.app.models.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	private static final List<Role> roles = List.of(
			new Role(1, "Administrador", "ROLE_ADMIN"),
			new Role(2, "Usuario","ROLE_USER"),
			new Role(3, "Moderador","ROLE_MODERATOR"));

	@Override
	public List<Role> listar() {
		return roles;
	}

	@Override
	public Role obtenerPorId(Integer id) {
        Role resultado = null;
        for(Role role: roles) {
        	if(id.equals(role.getId())) {
        		resultado = role;
        		break;
        	}
        }
		return resultado;
	}

}
