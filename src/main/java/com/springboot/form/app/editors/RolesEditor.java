package com.springboot.form.app.editors;

import com.springboot.form.app.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
@RequiredArgsConstructor
public class RolesEditor extends PropertyEditorSupport{

	private final RoleService service;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(text);
			setValue(service.obtenerPorId(id));
		} catch(NumberFormatException e) {
			setValue(null);
		}
	}

}
