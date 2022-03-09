package com.generation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/habilidades")



public class helloController {
	@GetMapping
			public String habilidadesUsadas() {
		return	"Mentalidades: muita Persistencia, orientação ao futuro e responsabilidade pessoal </br>"
				+ " Habilidades:Trabalho em equipe, atenção aos detalhes e proatividade </br>"
				+ " Objetivo: aprender mais para estar apta ao ambiente de trabalho";
		
	}
	

}
