
package br.edu.ufabc.rankingJogos.src.core.port.repository;

import br.edu.ufabc.rankingJogos.src.core.model.Console;

import java.util.List;


public interface ConsoleRepositoryPort {
    int count();

    int save(Console console);

    int update(Console console);

    int deleteById(int id);

    List<Console> findAll();

    Console findById(int id);
    
    List<Console> findByNome(String nome);
    
    List<Console> findByGameId(int id);

}
