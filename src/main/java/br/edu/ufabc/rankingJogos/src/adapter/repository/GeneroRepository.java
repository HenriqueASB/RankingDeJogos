
package br.edu.ufabc.rankingJogos.src.adapter.repository;

import br.edu.ufabc.rankingJogos.src.core.model.Genero;
import br.edu.ufabc.rankingJogos.src.core.port.repository.GeneroRepositoryPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class GeneroRepository implements GeneroRepositoryPort {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(id) FROM ranking.genero", Integer.class);
    }

    @Override
    public int save(Genero genero) {
        return jdbcTemplate.update(
                "insert into genero (genero) values(?)",
                genero.getGenero());
    }

    @Override
    public int update(Genero genero) {
        return jdbcTemplate.update(
                "update genero set genero = ? where id = ?",
                genero.getGenero());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
	                "delete from genero where id = ?",
	                id);
    }

    @Override
    public List<Genero> findAll() {
        return jdbcTemplate.query(
	                "select * from genero",
	                (rs, rowNum) ->
	                        new Genero(
	                                rs.getInt("id"),
	                                rs.getString("genero")
	                        )
	        );
    }

    @Override
    public Genero findById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from genero where id = ?",
                    new Object[]{id},
                    (rs, rowNum) ->
                            new Genero(
                                rs.getInt("id"),
                                rs.getString("genero")
                    )
        );
    }

    @Override
    public List<Genero> findByGenero(String genero) {
        return jdbcTemplate.query(
                "select * from genero where genero Like ?",
                new Object[]{genero},
                (rs, rowNum) ->
                	new Genero(
                        rs.getInt("id"),
                        rs.getString("genero")
                    )
            );
    }
    
}
