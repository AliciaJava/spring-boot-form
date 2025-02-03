package com.springboot.form.app.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	private Integer id;
	private String nombre;
	private String rol;

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Role)) {
			return false;
		}
		
		Role role = (Role) obj;
		return this.id != null && this.id.equals(role.getId());
	}

	@Override
	public int hashCode() {
		return this.id != null ? this.id.hashCode() : 0;
	}
}
