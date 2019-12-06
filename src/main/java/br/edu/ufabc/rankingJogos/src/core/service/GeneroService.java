
package br.edu.ufabc.rankingJogos.src.core.service;

import br.edu.ufabc.rankingJogos.src.core.model.Genero;
import br.edu.ufabc.rankingJogos.src.core.port.repository.GeneroRepositoryPort;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    @Autowired
	GeneroRepositoryPort generoRepository;

    public int create(Genero genero) {
        return generoRepository.save(genero);
    }

    public List<Genero> readAll() {
        return generoRepository.findAll();
    }

    public List<Genero> readByGenero(String genero) {
        return generoRepository.findByGenero(genero);
    }

    public Genero readById(int id) {
        return generoRepository.findById(id);
    }

    public int update(Genero genero) {
        return generoRepository.update(genero);
    }

    public int delete(int id) {
        return generoRepository.deleteById(id);
    }
    
}
