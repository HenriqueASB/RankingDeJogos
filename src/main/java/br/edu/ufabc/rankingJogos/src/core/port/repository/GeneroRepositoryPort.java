
package br.edu.ufabc.rankingJogos.src.core.port.repository;

import br.edu.ufabc.rankingJogos.src.core.model.Genero;

import java.util.List;

public interface GeneroRepositoryPort {
    int count();

    int save(Genero genero);

    int update(Genero genero);

    int deleteById(int id);

    List<Genero> findAll();

    Genero findById(int id);
    
    List<Genero> findByGenero(String genero);
    List<Genero> findByGameId(int id);

}
