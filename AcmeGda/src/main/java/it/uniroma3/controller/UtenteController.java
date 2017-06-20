package it.uniroma3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.model.Utente;
import it.uniroma3.service.UserService;

@Controller
public class UtenteController {

	@Autowired
	private UserService userService;


	//DOGET

	@GetMapping("/registrationform")
	public String showRegistrationForm(Model model) {
		Utente utente = new Utente();
		model.addAttribute("utente", utente);
		return "registrationform";
	}

	@GetMapping(value="/listautenti")
	public String showLista(Model model) {
		List<Utente> utenti = userService.findAll();
		model.addAttribute("utenti", utenti);
		return "listautenti";
	}


	@GetMapping(value="/user")
	public String showUser(@ModelAttribute("id") Long id, Model model) {
		Utente utente = userService.findbyId(id);
		model.addAttribute("utente",  utente);
		return "utente";
	}


	//DOPOST

	@PostMapping(value="/registrationform")
	public String inseriscinuovoUtente(@Valid @ModelAttribute Utente utente, 
			BindingResult bindingResult, Model model, @RequestParam(value="role") String role) {
		if (bindingResult.hasErrors()) {
			return "registrationform";
		}
		else {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String password = passwordEncoder.encode(utente.getPassword());
			utente.setPassword(password);
			utente.setRole(role);
			userService.add(utente);
			model.addAttribute(utente);

			return "registrationok";
		}




	}
}
