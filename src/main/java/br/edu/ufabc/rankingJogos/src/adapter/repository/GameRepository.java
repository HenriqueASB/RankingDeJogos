
package br.edu.ufabc.rankingJogos.src.adapter.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import br.edu.ufabc.rankingJogos.src.core.model.Game;
import br.edu.ufabc.rankingJogos.src.core.port.repository.GameRepositoryPort;
@Service
public class GameRepository implements GameRepositoryPort {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		return jdbcTemplate.queryForObject("SELECT count(id) FROM ranking.jogo", Integer.class);
	}


	@Override
	public int save(Game game) {
		return jdbcTemplate.update(
                "insert into jogo (titulo, empresa_id, genero_id,sinopse,urlFoto) values(?,?,?,?,?)",
                game.getTitulo(),game.getEmpresa_id(),game.getGenero_id(),game.getSinopse(),game.getUrlFoto());

	}

	@Override
	public int update(Game game) {
		return jdbcTemplate.update(
                "update jogo set titulo = ? , empresa_id = ?  , genero_id = ? , sinopse = ? , urlFoto = ? where id = ?",
                game.getTitulo(),game.getEmpresa_id(),game.getGenero_id(),game.getSinopse(),game.getUrlFoto(), game.getId());
	}


	@Override
	public int deleteById(Long id) {
		 return jdbcTemplate.update(
	                "delete from jogo where id = ?",
	                id);
	}

	@Override
	public List<Game> findAll() {
		 return jdbcTemplate.query(
	                "select * from jogo",
	                (rs, rowNum) ->
	                        new Game(
	                                rs.getInt("id"),
	                                rs.getString("titulo"),
	                                rs.getInt("empresa_id"),
	                                rs.getInt("genero_id"),
	                                rs.getString("sinopse"),
	                                rs.getString("urlFoto")
	                        )
	        );
	}


	@Override
	public Game findById(Long id) {
		return jdbcTemplate.queryForObject(
                "select * from jogo where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                	new Game(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getInt("empresa_id"),
                        rs.getInt("genero_id"),
                        rs.getString("sinopse"),
                        rs.getString("urlFoto")
                )
        );
	}

	@Override
	public List<Game> findByTitulo(String titulo) {
		return jdbcTemplate.query(
                "select * from jogo where titulo Like ?",
                new Object[]{titulo},
                (rs, rowNum) ->
                	new Game(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getInt("empresa_id"),
                        rs.getInt("genero_id"),
                        rs.getString("sinopse"),
                        rs.getString("urlFoto")
                )
        );
	}

}
