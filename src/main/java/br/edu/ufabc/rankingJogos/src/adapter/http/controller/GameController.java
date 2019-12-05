package br.edu.ufabc.rankingJogos.src.adapter.http.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufabc.rankingJogos.src.core.model.Game;
import br.edu.ufabc.rankingJogos.src.core.port.GameControllerPort;
import br.edu.ufabc.rankingJogos.src.core.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController implements GameControllerPort {

	@Autowired
	GameService service;
	
	@Override
	@PostMapping
	public void create(Game game) {
		service.create(game);
	}

	@Override
	@GetMapping
	public List<Game> readAll() {
		return service.readAll();
	}

	@Override
	@GetMapping("/titulo")
	public List<Game> readByTitulo(String titulo) {
		return service.readByTitulo(titulo);
	}

	@Override
	@GetMapping("/{id}")
	public Game readById(long id) {
		return service.readById(id);
	}

	@Override
	@PutMapping
	public int update(Game game) {
		return service.update(game);
	}

	@Override
	@DeleteMapping("/{id}")
	public int delete(long id) {
		return service.delete(id);
	}

}
