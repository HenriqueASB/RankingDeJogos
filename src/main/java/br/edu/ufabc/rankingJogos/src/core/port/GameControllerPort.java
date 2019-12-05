package br.edu.ufabc.rankingJogos.src.core.port;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.ufabc.rankingJogos.src.core.model.Game;

public interface GameControllerPort {
	
	public void create(@RequestBody Game game);
		
	public List<Game> readAll();
	
	public List<Game> readByTitulo(@RequestParam String titulo);
	
	public Game readById(@PathVariable long id);
	
	public int update(@RequestBody Game game);
	
	public int delete(@PathVariable long id);
}
