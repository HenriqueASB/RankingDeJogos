
package br.edu.ufabc.rankingJogos.src.core.service;

import br.edu.ufabc.rankingJogos.src.core.model.Console;
import br.edu.ufabc.rankingJogos.src.core.port.repository.ConsoleRepositoryPort;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService {
    
    @Autowired
	ConsoleRepositoryPort consoleRepository;

    public int create(Console console) {
        return consoleRepository.save(console);
    }

    public List<Console> readAll() {
        return consoleRepository.findAll();
    }

    public List<Console> readByNome(String nome) {
        return consoleRepository.findByNome(nome);
    }

    public Console readById(int id) {
        return consoleRepository.findById(id);
    }

    public int update(Console console) {
        return consoleRepository.update(console);
    }

    public int delete(int id) {
        return consoleRepository.deleteById(id);
    }
    
}
