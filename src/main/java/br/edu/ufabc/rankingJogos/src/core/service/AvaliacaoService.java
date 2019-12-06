
package br.edu.ufabc.rankingJogos.src.core.service;

import br.edu.ufabc.rankingJogos.src.core.model.Avaliacao;
import br.edu.ufabc.rankingJogos.src.core.port.repository.AvaliacaoRepositoryPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AvaliacaoService {
    
    @Autowired
    AvaliacaoRepositoryPort avaliacaoRepository;
    
    public int create(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }
		
    public List<Avaliacao> readAll(){
        return avaliacaoRepository.findAll();
    }

    public List<Avaliacao> readByUser_Id(int id){
        return avaliacaoRepository.findByUser_Id(id);
    }

    public List<Avaliacao> readByJogo_Id(int id){
        return avaliacaoRepository.findByJogo_Id(id);
    }

    public int update(Avaliacao avaliacao){
        return avaliacaoRepository.update(avaliacao);
    }

    public int delete(int id){
        return avaliacaoRepository.delete(id);
    }
    
    public int calculaNota(int jogo_id){
        return avaliacaoRepository.nota(jogo_id);
    }
}
