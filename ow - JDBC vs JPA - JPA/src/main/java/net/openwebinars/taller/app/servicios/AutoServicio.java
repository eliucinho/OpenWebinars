/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.openwebinars.taller.app.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.openwebinars.taller.app.modelos.Auto;
import java.util.Optional;
import net.openwebinars.taller.app.repositorios.AutoRepositorio;

@Service
public class AutoServicio {
        @Autowired
	private AutoRepositorio repositorio;
        
	public Auto guardar(Auto entity) {
		return repositorio.save(entity);
	}

	public void eliminar(Long id) {
		repositorio.deleteById(id);
	}

	public Optional<Auto> getValor(Long id) {
		return repositorio.findById(id);
	}

	public List<Auto> getTodos() {
		return (List<Auto>) repositorio.findAll();
	}
}


