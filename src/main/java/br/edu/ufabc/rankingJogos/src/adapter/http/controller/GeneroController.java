
package br.edu.ufabc.rankingJogos.src.adapter.http.controller;

import br.edu.ufabc.rankingJogos.src.core.model.Genero;
import br.edu.ufabc.rankingJogos.src.core.port.GeneroControllerPort;
import br.edu.ufabc.rankingJogos.src.core.service.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genero")
public class GeneroController implements GeneroControllerPort{

    @Autowired
	GeneroService service;
    
    @Override
    @PostMapping
    public void create(Genero genero) {
        service.create(genero);
    }

    @Override
    @GetMapping
    public List<Genero> readAll() {
        return service.readAll();
    }

    @Override
    @GetMapping
    public List<Genero> readByGenero(String genero) {
        return service.readByGenero(genero);
    }

    @Override
    @GetMapping
    public Genero readById(int id) {
        return service.readById(id);
    }

    @Override
    @PutMapping
    public int update(Genero genero) {
        return service.update(genero);
    }

    @Override
    @DeleteMapping
    public int delete(int id) {
        return service.delete(id);
    }
    
}
