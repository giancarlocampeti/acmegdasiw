package it.uniroma3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long> {
	
	public Opera findByTitolo(String titolo);
	public List<Opera> findByTecnica(String tecnica);
	public List<Opera> findByAnno(int anno);
	public List<Opera> findByAutore(Autore autore);


}
