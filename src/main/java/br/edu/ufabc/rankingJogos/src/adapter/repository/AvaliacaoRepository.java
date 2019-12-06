package br.edu.ufabc.rankingJogos.src.adapter.repository;

import br.edu.ufabc.rankingJogos.src.core.model.Avaliacao;
import br.edu.ufabc.rankingJogos.src.core.port.repository.AvaliacaoRepositoryPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoRepository implements AvaliacaoRepositoryPort {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(id) FROM ranking.avaliacao", Integer.class);
    }

    @Override
    public int save(Avaliacao avaliacao) {
        return jdbcTemplate.update(
                "insert into avaliacao (user_id, jogo_id, nota) values(?,?,?)",
                avaliacao.getUser_id(),avaliacao.getJogo_id(),avaliacao.getNota());
    }

    @Override
    public int update(Avaliacao avaliacao) {
        return jdbcTemplate.update(
                "update avaliacao set user_id = ? , jogo_id = ? , nota = ? where id = ?",
                avaliacao.getUser_id(),avaliacao.getJogo_id(),avaliacao.getNota());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update(
	                "delete from avaliacao where id = ?",
	                id);
    }

    @Override
    public List<Avaliacao> findAll() {
        return jdbcTemplate.query(
	                "select * from avaliacao",
	                (rs, rowNum) ->
	                        new Avaliacao(
	                                rs.getInt("id"),
	                                rs.getInt("user_id"),
	                                rs.getInt("jogo_id"),
                                        rs.getInt("nota")
	                        )
	        );
    }

    @Override
    public List<Avaliacao> findByUser_Id(int id) {
        return jdbcTemplate.query(
                "select * from avaliacao where user_id = ?",
                (rs, rowNum) ->
                	new Avaliacao(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getInt("jogo_id"),
                            rs.getInt("nota")
                )
        );
    }

    @Override
    public List<Avaliacao> findByJogo_Id(int id) {
        return jdbcTemplate.query(
                "select * from avaliacao where jogo_id = ?",
                (rs, rowNum) ->
                	new Avaliacao(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getInt("jogo_id"),
                            rs.getInt("nota")
                )
        );
    }
  
    @Override
    public Double nota(int jogo_id){       
        return jdbcTemplate.queryForObject("SELECT AVG(nota) FROM ranking.avaliacao where jogo_id = ?", Double.class, jogo_id);
    }
}
