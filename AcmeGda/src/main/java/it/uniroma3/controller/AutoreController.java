package it.uniroma3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Opera;
import it.uniroma3.service.AutoreService;
import it.uniroma3.service.OperaService;

@Controller
public class AutoreController {

	@Autowired
	private AutoreService autoreService;
	@Autowired
	private OperaService operaService;

	//DOGET

	//Rimanda form inserimento autore
	@GetMapping(value="/autoreform")
	public String showAutoreForm(@ModelAttribute Autore autore) {
		return "autoreform";
	}


	//Rimanda all'i-esimo autore nella lista degli autori
	@GetMapping(value="/autore")
	public String showAutore(@ModelAttribute("id") Long id, Model model) {
		Autore autore = autoreService.findAutorebyId(id);
		model.addAttribute(autore);
		return "autore";

	}

	//Rimanda alla lista di tutti gli autori
	@GetMapping(value="/listaautori")
	public String showLista(Model model) {
		List<Autore> autori = autoreService.findAll();
		model.addAttribute("autori", autori);
		return "listaautori";
	}

	//DOPOST

	//Gestione dell'inserimento dell'autore
	@PostMapping(value="/autoreform")
	public String inserisciAutore(@Valid @ModelAttribute Autore autore, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "autoreform";
		}
		else {
			model.addAttribute(autore);
			autoreService.addAutore(autore);
		}

		List<Autore> autori = autoreService.findAll();
		model.addAttribute("autori", autori);
		return "listaautori";
	}

	@GetMapping(value="/cancellaautore")
	public String cancellaAutore(@ModelAttribute("id") Long id, Model model) {
		Autore autore = autoreService.findAutorebyId(id);
		if(!autore.getOpere().isEmpty()) {
			for(Opera o : autore.getOpere()) {
				operaService.deleteOpera(o);
			}
		} 
		autoreService.deleteAutore(autore);
		List<Autore> autori = autoreService.findAll();
		model.addAttribute("autori", autori);
		return "listaautori";

	}







}



