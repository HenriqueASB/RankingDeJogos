
package br.edu.ufabc.rankingJogos.src.core.port.repository;

import br.edu.ufabc.rankingJogos.src.core.model.Genero;

import java.util.List;

public interface GeneroRepositoryPort {
    int count();

    int save(Genero genero);

    int update(Genero genero);

    int deleteById(Long id);

    List<Genero> findAll();

    Genero findById(Long id);
    
    List<Genero> findByGenero(String genero);
}
