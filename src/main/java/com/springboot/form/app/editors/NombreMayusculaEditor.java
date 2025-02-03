package com.springboot.form.app.editors;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class NombreMayusculaEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		setValue(text.toUpperCase().trim());
	}

}
