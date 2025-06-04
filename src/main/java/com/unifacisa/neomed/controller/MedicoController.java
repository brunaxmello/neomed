package com.unifacisa.neomed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.neomed.entity.Medico;
import com.unifacisa.neomed.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService; 
	
	@GetMapping
	public List<Medico> lisarTodos() {
		return medicoService.listarTodos();
	}
	
}	
	

