package br.edu.ufabc.rankingJogos.src.core.port;

import org.springframework.web.bind.annotation.RequestBody;

import br.edu.ufabc.rankingJogos.src.core.model.Game;

public interface GameControllerPort {
	
	public void create(@RequestBody Game game);
	
	public String jogo();
}
