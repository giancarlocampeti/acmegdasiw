package it.uniroma3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Opera;
import it.uniroma3.repository.OperaRepository;

@Service
public class OperaService {
	
	@Autowired
	private OperaRepository repository;
	
	public OperaService(){
		
	}
	
	@Transactional
	public void addOpera(final Opera opera) {
		this.repository.save(opera);
	}

	@Transactional
	public void deleteOpera(final Opera opera) {
		repository.delete(opera);
	}

	public Opera findOperabyId(Long id) {
		return this.repository.findOne(id);
	}

	public List<Opera> findAll() {
		return (List<Opera>) this.repository.findAll(); 

	}
	
	public List<Opera> findOperabyAutore(Autore autore) {
		return this.repository.findByAutore(autore);
		
	}
	

}
