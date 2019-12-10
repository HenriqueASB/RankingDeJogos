
package br.edu.ufabc.rankingJogos.src.adapter.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import br.edu.ufabc.rankingJogos.src.core.model.Console;
import br.edu.ufabc.rankingJogos.src.core.model.Game;
import br.edu.ufabc.rankingJogos.src.core.model.Genero;
import br.edu.ufabc.rankingJogos.src.core.port.repository.AvaliacaoRepositoryPort;
import br.edu.ufabc.rankingJogos.src.core.port.repository.ConsoleRepositoryPort;
import br.edu.ufabc.rankingJogos.src.core.port.repository.EmpresaRepositoryPort;
import br.edu.ufabc.rankingJogos.src.core.port.repository.GameRepositoryPort;
import br.edu.ufabc.rankingJogos.src.core.port.repository.GeneroRepositoryPort;
@Service
public class GameRepository implements GameRepositoryPort {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private GeneroRepositoryPort generoRepository;
	
	@Autowired
    private EmpresaRepositoryPort empresaRepository;
	
	@Autowired
	private ConsoleRepositoryPort consoleRepository;
	
	@Autowired 
	AvaliacaoRepositoryPort avaliacaoRepository;
	
	@Override
	public int count() {
		return jdbcTemplate.queryForObject("SELECT count(id) FROM ranking.jogo", Integer.class);
	}


	@Override
	public int save(Game game) {
		jdbcTemplate.update(
                "insert into jogo (titulo, empresa_id, sinopse, urlFoto) values(?,?,?,?)",
                game.getTitulo(),game.getEmpresa().getId(),game.getSinopse(),game.getUrlFoto());
                
                for (int i = 0; i < game.getGenero().length; i++) {
                    jdbcTemplate.update(
                    "insert into jogo_genero (jogo_id, genero_id) values(?,?)",
                    game.getId(),game.getGenero()[i].getId());
                }
                
                for (int i = 0; i < game.getConsole().length; i++) {
                    jdbcTemplate.update(
                    "insert into jogo_console (jogo_id, console_id) values(?,?)",
                    game.getId(),game.getConsole()[i].getId());
                }
                
                return 0;
	}

        
	@Override
	public int update(Game game) {
		return jdbcTemplate.update(
                "update jogo set titulo = ? , empresa_id = ?  , sinopse = ? , urlFoto = ? where id = ?",
                game.getTitulo(),game.getEmpresa().getId(),game.getSinopse(),game.getUrlFoto(), game.getId());
	}


	@Override
	public int deleteById(Long id) {
		 return jdbcTemplate.update(
	                "delete from jogo where id = ?",
	                id);
	}

	@Override
	public List<Game> findAll() {
		int n = generoRepository.count();
		Genero[] g = new Genero[n];
		int i = generoRepository.count();
		Console[] c = new Console[i];
		 return jdbcTemplate.query(
	                "select * from jogo",
	                (rs, rowNum) ->
	                        new Game(
	                                rs.getInt("id"),
	                                rs.getString("titulo"),
	                                empresaRepository.findById(rs.getInt("empresa_id")),
	                                generoRepository.findByGameId(rs.getInt("id")).toArray(g),
	                                consoleRepository.findByGameId(rs.getInt("id")).toArray(c),
	                                rs.getString("sinopse"),
	                                rs.getString("urlFoto"),
	                                avaliacaoRepository.nota(rs.getInt("id"))
	                        )
	        );
	}


	@Override
	public Game findById(Long id) {
		int n = generoRepository.count();
		Genero[] g = new Genero[n];
		int i = generoRepository.count();
		Console[] c = new Console[i];
		return jdbcTemplate.queryForObject(
                "select * from jogo where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                	new Game(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        empresaRepository.findById(rs.getInt("empresa_id")),
                        generoRepository.findByGameId(rs.getInt("id")).toArray(g),
                        consoleRepository.findByGameId(rs.getInt("id")).toArray(c),
                        rs.getString("sinopse"),
                        rs.getString("urlFoto"),
                        avaliacaoRepository.nota(rs.getInt("id"))
                )
        );
	}

	@Override
	public List<Game> findByTitulo(String titulo) {
		int n = generoRepository.count();
		Genero[] g = new Genero[n];
		int i = generoRepository.count();
		Console[] c = new Console[i];
		return jdbcTemplate.query(
                "select * from jogo where titulo Like ?",
                new Object[]{titulo},
                (rs, rowNum) ->
                	new Game(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        empresaRepository.findById(rs.getInt("empresa_id")),
                        generoRepository.findByGameId(rs.getInt("id")).toArray(g),
                        consoleRepository.findByGameId(rs.getInt("id")).toArray(c),
                        rs.getString("sinopse"),
                        rs.getString("urlFoto"),
                        avaliacaoRepository.nota(rs.getInt("id"))
                )
        );
	}

}
