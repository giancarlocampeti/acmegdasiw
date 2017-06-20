package it.uniroma3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Autore;
import it.uniroma3.repository.AutoreRepository;

@Service
public class AutoreService {

	@Autowired
	private AutoreRepository repository;

	public AutoreService(){

	}

	@Transactional
	public void addAutore(final Autore autore) {
		this.repository.save(autore);
	}

	@Transactional
	public void deleteAutore(Autore autore) {
		this.repository.delete(autore);
	}

	public Autore findAutorebyId(Long id) {
		return this.repository.findOne(id);
	}

	public List<Autore> findAll() {
		return this.repository.findAll(); 

	}

	public List<Autore> findbyCorrenteArtistica(String correnteArtistica) {
		return this.repository.findByCorrenteArtistica(correnteArtistica);
	}

}

