/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.rankingJogos.src.core.port.repository;
import java.util.List;

import br.edu.ufabc.rankingJogos.src.core.model.Avaliacao;
/**
 *
 * @author Pichau
 */
public interface AvaliacaoRepositoryPort {
    int count();

    int save(Avaliacao avaliacao);

    int update(Avaliacao avaliacao);
    
    int delete(int id);

    List<Avaliacao> findAll();

    List<Avaliacao> findByUser_Id(int id);
    
    List<Avaliacao> findByJogo_Id(int id);
    
    Double nota(int jogo_id);
    
}
