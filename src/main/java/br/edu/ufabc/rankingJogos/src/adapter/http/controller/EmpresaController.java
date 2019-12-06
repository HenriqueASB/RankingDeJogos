
package br.edu.ufabc.rankingJogos.src.adapter.http.controller;

import br.edu.ufabc.rankingJogos.src.core.model.Empresa;
import br.edu.ufabc.rankingJogos.src.core.port.EmpresaControllerPort;
import br.edu.ufabc.rankingJogos.src.core.service.EmpresaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/empresa")
public class EmpresaController implements EmpresaControllerPort{

    @Autowired
	EmpresaService service;
    
    @Override
    @PostMapping
    public void create(Empresa empresa) {
        service.create(empresa);
    }

    @Override
    @GetMapping
    public List<Empresa> readAll() {
        return service.readAll();
    }

    @Override
    @GetMapping("/nome")
    public List<Empresa> readByNome(String nome) {
        return service.readByNome(nome);
    }

    @Override
    @GetMapping("/{id}")
    public Empresa readById(int id) {
        return service.readById(id);
    }

    @Override
    @PutMapping
    public int update(Empresa empresa) {
        return service.update(empresa);
    }

    @Override
    @DeleteMapping
    public int delete(int id) {
        return service.delete(id);
    }
    
}
