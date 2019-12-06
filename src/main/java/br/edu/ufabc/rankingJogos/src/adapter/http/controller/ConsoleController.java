
package br.edu.ufabc.rankingJogos.src.adapter.http.controller;

import br.edu.ufabc.rankingJogos.src.core.model.Console;
import br.edu.ufabc.rankingJogos.src.core.port.ConsoleControllerPort;
import br.edu.ufabc.rankingJogos.src.core.service.ConsoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/console")
public class ConsoleController implements ConsoleControllerPort {

    @Autowired
	ConsoleService service;
    
    @Override
    @PostMapping
    public void create(Console console) {
        service.create(console);
    }

    @Override
    @GetMapping
    public List<Console> readAll() {
        return service.readAll();
    }

    @Override
    @GetMapping("/nome")
    public List<Console> readByNome(String nome) {
        return service.readByNome(nome);
    }

    @Override
    @GetMapping("/{id}")
    public Console readById(int id) {
        return service.readById(id);
    }

    @Override
    @PutMapping
    public int update(Console console) {
        return service.update(console);
    }

    @Override
    @DeleteMapping
    public int delete(int id) {
        return service.delete(id);
    }
    
}
