/**
 * 
 */
package br.edu.ufabc.rankingJogos.src.adapter.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import br.edu.ufabc.rankingJogos.src.core.model.Game;
import br.edu.ufabc.rankingJogos.src.core.port.repository.GameRepositoryPort;

/**
 * @author henri
 *
 */
public class GameRepository implements GameRepositoryPort {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see br.edu.ufabc.rankingJogos.src.core.port.repository.GameRepositoryPort#save(br.edu.ufabc.rankingJogos.src.core.model.Game)
	 */
	@Override
	public int save(Game game) {
		return jdbcTemplate.update(
                "insert into jogo (titulo, empresa_id, genero_id,sinopse,urlFoto) values(?,?,?,?,?)",
                game.getTitulo(),game.getEmpresa_id(),game.getGenero_id(),game.getSinopse(),game.getUrlFoto());

	}

	/* (non-Javadoc)
	 * @see br.edu.ufabc.rankingJogos.src.core.port.repository.GameRepositoryPort#update(br.edu.ufabc.rankingJogos.src.core.model.Game)
	 */
	@Override
	public int update(Game game) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see br.edu.ufabc.rankingJogos.src.core.port.repository.GameRepositoryPort#deleteById(java.lang.Long)
	 */
	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see br.edu.ufabc.rankingJogos.src.core.port.repository.GameRepositoryPort#findAll()
	 */
	@Override
	public List<Game> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.edu.ufabc.rankingJogos.src.core.port.repository.GameRepositoryPort#findById(java.lang.Long)
	 */
	@Override
	public Game findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.edu.ufabc.rankingJogos.src.core.port.repository.GameRepositoryPort#findByTitulo(java.lang.String)
	 */
	@Override
	public List<Game> findByTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

}
