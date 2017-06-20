package it.uniroma3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.model.Utente;
import it.uniroma3.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository; 

    public List<Utente> findAll() {
        return this.userRepository.findAll();
    }

    @Transactional
    public void add(final Utente user) {
        this.userRepository.save(user);
    }

	public Utente findbyId(Long id) {
		return this.userRepository.findOne(id);
	}

}
