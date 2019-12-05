package br.edu.ufabc.rankingJogos.src.adapter.http.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufabc.rankingJogos.src.core.model.Game;
import br.edu.ufabc.rankingJogos.src.core.port.GameControllerPort;

@RestController
@RequestMapping("/game")
public class GameController implements GameControllerPort {

	@Override
	@PostMapping
	public void create(Game game) {
		System.out.println(game.getTitulo());
	}

	@Override
	@GetMapping
	public String jogo() {
		// TODO Auto-generated method stub
		return "jasfgkhfhgsdfhgfhksdgfhjadsg";
	}

}
