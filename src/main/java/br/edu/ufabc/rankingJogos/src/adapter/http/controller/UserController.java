package br.edu.ufabc.rankingJogos.src.adapter.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufabc.rankingJogos.src.core.model.Usuario;
import br.edu.ufabc.rankingJogos.src.core.port.UserControllerPort;
import br.edu.ufabc.rankingJogos.src.core.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerPort {
	
	@Autowired
	UsuarioService service;

	@Override
	@PostMapping("/create")
	public void create(Usuario request) {
		service.create(request);
	}

	@Override
	@PostMapping("/login")
	public String login(Usuario request) {
		String token;
		token  = service.login(request);
		return token;
	}

}
