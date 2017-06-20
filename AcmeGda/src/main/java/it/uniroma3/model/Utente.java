package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Utente {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1)
    private String username;

    @NotNull
    private String password;
    
    @NotNull
    @Size(min=1)
    private String firstName;
    
    @NotNull
    @Size(min=1)
    private String lastName;
    
    @NotNull
   	private String role;
    
    
	public Utente() {
    	
    }
    
    public Utente(String username, String password, String firstName, String lastName, String role) {
    	this.username=username;
    	this.password=password;
    	this.firstName=firstName;
    	this.lastName=lastName;
    	this.role=role;
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
//	public void setAdmin() {
//		this.role = "ADMIN";
//	}
//	
//	public void setUser() {
//		this.role = "USER";
//	}
//	
	
	

}
