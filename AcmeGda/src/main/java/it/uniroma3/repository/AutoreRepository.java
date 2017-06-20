package it.uniroma3.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore,Long> {
	
	public Autore findByNome(String nome);
	public Autore findByCognome(String cognome);
	public List<Autore> findByNazionalita(String nazionalita);
	public List<Autore> findByDataNascita(Date dataNascita);
	public List<Autore> findByDataMorte(Date dataMorte);
	public List<Autore> findByCorrenteArtistica(String correnteArtistica);
	public List<Autore> findAll();




}
