package br.com.izidrocop.izibanck.controler;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.izidrocop.izibanck.dao.ClienteDAO;
import br.com.izidrocop.izibanck.nodel.Cliente;

@RestController
public class ClienteControler {
	@Autowired
	private ClienteDAO dao;

	@GetMapping("/cliente")
	public ArrayList<Cliente> reculperarTodos() {
		return (ArrayList<Cliente>) dao.findAll();
	}
}
