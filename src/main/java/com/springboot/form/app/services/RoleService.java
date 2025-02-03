package com.springboot.form.app.services;

import java.util.List;

import com.springboot.form.app.models.domain.Role;

public interface RoleService {
	
	public List<Role> listar();
	public Role obtenerPorId(Integer id);

}
