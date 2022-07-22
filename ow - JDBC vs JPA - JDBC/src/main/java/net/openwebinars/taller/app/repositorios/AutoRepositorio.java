package net.openwebinars.taller.app.repositorios;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import net.openwebinars.taller.app.modelos.Auto;

public interface AutoRepositorio {
	public Auto guardar(Auto entity);
	public void eliminar(Long id) ;
	public Optional<Auto> getValor(Long id);
	public List<Auto> getTodos() ;
}





