package br.com.izidrocop.izibanck.controler;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.izidrocop.izibanck.dao.ContaDAO;
import br.com.izidrocop.izibanck.nodel.Conta;

@RestController
public class ContaController {
	@Autowired
	private ContaDAO dao;

	@GetMapping("/contas")
	public ArrayList<Conta> reculperarTodas() {
		return (ArrayList<Conta>) dao.findAll();
	}

	@GetMapping("/contas/{numero}")
	public ResponseEntity<Conta> reculperarNumero(@PathVariable int numero) {
		Conta resultado=dao.findById(numero).orElse(null);
		if(resultado != null) {
			return ResponseEntity.ok(resultado);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
