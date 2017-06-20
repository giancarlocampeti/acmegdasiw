package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Autore {
	
	// STUDIARE .IDENTITY //
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1, max=30)
	private String nome;
	
	@NotNull
	@Size(min=1, max=30)
	private String cognome;
	
	@NotNull
	@Size(min=1, max=30)
	private String nazionalita;
	
	
	@NotNull
	@DateTimeFormat(pattern ="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	
	@NotNull
	@DateTimeFormat(pattern ="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataMorte;
	
	@NotNull
	@Size(min=1, max=20)
	private String correnteArtistica;
	
	@OneToMany 
	private List<Opera> opere;
	
	protected Autore() {
	}
	
	public Autore(String nome, String cognome, String nazionalita, Date dataNascita, Date dataMorte, String correnteArtistica) {
		this.nome=nome;
		this.cognome=cognome;
		this.nazionalita=nazionalita;
		this.dataNascita=dataNascita;
		this.dataMorte=dataMorte;
		this.correnteArtistica=correnteArtistica;
		this.opere= new ArrayList<>();
		
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}
	public String getCorrenteArtistica() {
		return correnteArtistica;
	}

	public void setCorrenteArtistica(String correnteArtistica) {
		this.correnteArtistica = correnteArtistica;
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}

	
	

}
