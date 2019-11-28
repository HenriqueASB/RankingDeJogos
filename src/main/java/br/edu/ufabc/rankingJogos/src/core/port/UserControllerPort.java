package br.edu.ufabc.rankingJogos.src.core.port;

import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ufabc.rankingJogos.src.core.model.Usuario;

public interface UserControllerPort {
	
	public void create(@RequestBody Usuario request);
	
	public String login(@RequestBody Usuario request);	

}
