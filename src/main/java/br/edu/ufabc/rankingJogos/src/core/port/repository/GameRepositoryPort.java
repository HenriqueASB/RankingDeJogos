package br.edu.ufabc.rankingJogos.src.core.port.repository;

import java.util.List;

import br.edu.ufabc.rankingJogos.src.core.model.Game;

public interface GameRepositoryPort {
    int count();

    int save(Game game);

    int update(Game game);

    int deleteById(Long id);

    List<Game> findAll();

    Game findById(Long id);
    
    List<Game> findByTitulo(String titulo);
    
}


