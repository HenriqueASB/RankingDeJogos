
package br.edu.ufabc.rankingJogos.src.adapter.repository;

import br.edu.ufabc.rankingJogos.src.core.model.Console;
import br.edu.ufabc.rankingJogos.src.core.port.repository.ConsoleRepositoryPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsoleRepository implements ConsoleRepositoryPort{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(id) FROM ranking.console", Integer.class);
    }

    @Override
    public int save(Console console) {
        return jdbcTemplate.update(
                "insert into console (nome, fabricante, ano) values(?,?,?)",
                console.getNome(), console.getFabricante(), console.getAno());
    }

    @Override
    public int update(Console console) {
        return jdbcTemplate.update(
                "update console set nome = ? , fabricante = ? , ano = ? where id = ?",
                console.getNome(),console.getFabricante(),console.getAno());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
	                "delete from console where id = ?",
	                id);
    }

    @Override
    public List<Console> findAll() {
        return jdbcTemplate.query(
	                "select * from console",
	                (rs, rowNum) ->
	                        new Console(
	                                rs.getInt("id"),
	                                rs.getString("nome"),
	                                rs.getString("fabricante"),
                                        rs.getString("ano")
	                        )
	        );
    }

    @Override
    public Console findById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from console where id = ?",
                    new Object[]{id},
                    (rs, rowNum) ->
                            new Console(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("fabricante"),
                                rs.getString("ano")
                            )
                    );
    }

    @Override
    public List<Console> findByNome(String nome) {
        return jdbcTemplate.query(
                "select * from console where nome Like ?",
                new Object[]{nome},
                (rs, rowNum) ->
                	new Console(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("fabricante"),
                        rs.getString("ano")
                )
        );
    }

	@Override
	public List<Console> findByGameId(int id) {
		return jdbcTemplate.query(
                "select distinct c.* from jogo as j \r\n" + 
                "join jogo_console as jc on j.id = jc.jogo_id \r\n" + 
                "join console as c on jc.console_id = c.id \r\n" + 
                "join jogo_genero as jg on jg.jogo_id = j.id \r\n" + 
                "join genero as g on g.id = jg.genero_id\r\n" + 
                "where j.id = ?;",
                new Object[]{id},
                (rs, rowNum) ->
                	new Console(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("fabricante"),
                        rs.getString("ano")
                    )
            );
	}
    
}
