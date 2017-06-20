package it.uniroma3.model;



import javax.persistence.Entity;
import java.net.URL;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
public class Opera {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1)
	private String titolo;
	
	@NotNull
	private int anno;
	
	@NotNull
	@Size(min=1, max=20)
	private String tecnica;
	
	// PENSARE MEGLIO AL TIPO, POSSIBILE MENU A TENDINA NELLA JSP RISULTANTE//

	@NotNull
	@Min(1)
	private int altezza;
	
	@NotNull
	@Min(1)
	private int larghezza;
	
	@NotNull
	
	private URL imgURL;

	@NotNull
	@ManyToOne
	private Autore autore;

	public Opera(){
		
	}
	
	public Opera(String titolo, int anno, String tecnica, int altezza, int larghezza, Autore autore, URL imgURL) {
		this.titolo=titolo;
		this.anno=anno;
		this.tecnica=tecnica;
		this.altezza=altezza;
		this.larghezza=larghezza;
		this.autore=autore;
		this.imgURL=imgURL;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	
	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public int getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}
	
	public URL getImgURL() {
		return imgURL;
	}

	public void setImgURL(URL imgURL) {
		this.imgURL = imgURL;
	}
	
	
	

}
