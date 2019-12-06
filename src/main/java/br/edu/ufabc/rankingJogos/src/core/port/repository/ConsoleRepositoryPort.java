
package br.edu.ufabc.rankingJogos.src.core.port.repository;

import br.edu.ufabc.rankingJogos.src.core.model.Console;

import java.util.List;


public interface ConsoleRepositoryPort {
    int count();

    int save(Console console);

    int update(Console console);

    int deleteById(Long id);

    List<Console> findAll();

    Console findById(Long id);
    
    List<Console> findByConsole(String console);
}
