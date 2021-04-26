package com.helloworld.hallo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping ("/hallo") //Caminho que irá utilizar no Postman para acessar esse ponto te acesso Controller	
public class HalloController {
	
	@GetMapping("/exercicio1") //Método que utilizará no Postman p/ localizar a mensagem
	public String hallo() { //Nome do método
		return "Mentalidade de crescimento, atenção aos detalhes e persistência";
	}
	
	@GetMapping("/exercicio2") 
	public String exercicio2() { 
		return "Aprender todo conteúdo e entregar todas as atividades";
	}

}
