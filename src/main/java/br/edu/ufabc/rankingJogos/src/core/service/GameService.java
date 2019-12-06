package br.edu.ufabc.rankingJogos.src.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.rankingJogos.src.core.model.Game;
import br.edu.ufabc.rankingJogos.src.core.model.Genero;
import br.edu.ufabc.rankingJogos.src.core.port.repository.GameRepositoryPort;

@Service
public class GameService {
	
	@Autowired
	GameRepositoryPort gameRepository;
	
	public int create(Game game) {
		return gameRepository.save(game);
	}
	
	public List<Game> readAll(){
		return gameRepository.findAll();
	}
	
	public List<Game> readByTitulo(String titulo){
		return gameRepository.findByTitulo(titulo);
	}
	
	public Game readById(long id){
		return gameRepository.findById(id);
	}
	
	public int update(Game game) {
		return gameRepository.update(game);
	}
	
	public int delete(long id) {
		return gameRepository.deleteById(id);
	}

}
