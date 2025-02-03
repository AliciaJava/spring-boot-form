package com.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.springboot.form.app.services.PaisService;

@Component
@RequiredArgsConstructor
public class PaisPropertyEditor extends PropertyEditorSupport {

	private final PaisService service;

	@Override
	public void setAsText(String idString) throws IllegalArgumentException {

		try {
			Integer id = Integer.parseInt(idString);
			this.setValue(service.obtenerPorId(id));
		} catch (NumberFormatException e) {
			setValue(null);
		}

	}

}
