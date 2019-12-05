
package br.edu.ufabc.rankingJogos.src.adapter.http.controller;

import br.edu.ufabc.rankingJogos.src.core.model.Avaliacao;
import br.edu.ufabc.rankingJogos.src.core.port.AvaliacaoControllerPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufabc.rankingJogos.src.core.service.AvaliacaoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController implements AvaliacaoControllerPort{

    @Autowired
    AvaliacaoService service;

    @Override
    @PostMapping
    public void create(Avaliacao avaliacao) {
        service.create(avaliacao);
    }

    @Override
    @GetMapping
    public List<Avaliacao> readAll() {
        return service.readAll();
    }

    @Override
    @GetMapping("/user_id")
    public List<Avaliacao> readByUser_Id(int user_id) {
        return service.readByUser_Id(user_id);
    }

    @Override
    @GetMapping("/jogo_id")
    public List<Avaliacao> readByJogo_Id(int jogo_id) {
        return service.readByJogo_Id(jogo_id);
    }

    @Override
    @PutMapping
    public int update(Avaliacao avaliacao) {
        return service.update(avaliacao);
    }

    @Override
    @DeleteMapping
    public int delete(int id) {
        return service.delete(id);
    }
}
