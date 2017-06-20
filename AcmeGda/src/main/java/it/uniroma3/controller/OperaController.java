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
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Opera;
import it.uniroma3.service.AutoreService;
import it.uniroma3.service.OperaService;

@Controller
public class OperaController {

	@Autowired
	private OperaService operaService;

	@Autowired
	private AutoreService autoreService;



	//DOGET

	//Rimanda alla lista di tutti le opere
	@GetMapping(value="/listaopere")
	public String showLista(Model model) {
		List<Opera> opere = operaService.findAll();
		model.addAttribute("opere", opere);
		return "listaopere";
	}
	
	@GetMapping(value="/listaopereautore")
	public String showListaOpereAutore(@ModelAttribute("id") Long id, Model model) {
		Autore autore = autoreService.findAutorebyId(id);
		List<Opera> opere = operaService.findOperabyAutore(autore);
		model.addAttribute("opere", opere);
		return "listaopere";
	}


	@GetMapping(value="/operaform")
	public String showOperaForm(Model model) {
		Opera o = new Opera();
		List<Autore> autori = this.autoreService.findAll();
		model.addAttribute("autori", autori);
		model.addAttribute("opera", o);
		return "operaform";
	}

	//Rimanda all'i-esima opera
	@GetMapping(value="/opera")
	public String showOpera(@ModelAttribute("id") Long id, Model model) {
		Opera opera = operaService.findOperabyId(id);
		model.addAttribute("opera",  opera);
		return "opera";
	}
	
	@GetMapping(value="/cancellaopera")
	public String cancellaAutore(@ModelAttribute("id") Long id, Model model) {
		Opera opera = operaService.findOperabyId(id);
		
		operaService.deleteOpera(opera);
		List<Opera> opere = operaService.findAll();
		model.addAttribute("opere", opere);
		return "listaopere";

	}



	//DOPOST

	//Gestione dell'inserimento dell'opera PASSARE ID ARTISTA
	@PostMapping(value="/inserisciopera")
	public String inserisciOpera(@Valid @ModelAttribute Opera o, Model model, @RequestParam(value="autore") Long id,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "operaform";
		}
		else {		
			Autore autore = autoreService.findAutorebyId(id);
			o.setAutore(autore);
			operaService.addOpera(o);
		}
		List<Opera> opere = operaService.findAll();
		model.addAttribute("opere", opere);

		return "listaopere";
	}


}
