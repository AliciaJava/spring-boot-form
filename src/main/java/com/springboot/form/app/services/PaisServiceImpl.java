package com.springboot.form.app.services;

import com.springboot.form.app.models.domain.Pais;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

	private static final List<Pais> lista = List.of(
			new Pais(1, "ES", "España"),
			new Pais(2, "MX", "México"),
			new Pais(3, "CL", "Chile"),
			new Pais(4, "AR", "Argentina"),
			new Pais(5, "PE", "Perú"),
			new Pais(6, "CO", "Colombia"),
			new Pais(7, "VE", "Venezuela"));

	@Override
	public List<Pais> listar() {
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais resultado = null;
		for(Pais pais: lista) {
			if(id.equals(pais.getId())) {
				resultado = pais;
				break;
			}
		}
		return resultado;
	}

}
