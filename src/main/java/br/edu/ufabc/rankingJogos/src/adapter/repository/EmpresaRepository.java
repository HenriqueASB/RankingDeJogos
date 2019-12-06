
package br.edu.ufabc.rankingJogos.src.adapter.repository;

import br.edu.ufabc.rankingJogos.src.core.model.Empresa;
import br.edu.ufabc.rankingJogos.src.core.port.repository.EmpresaRepositoryPort;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmpresaRepository implements EmpresaRepositoryPort{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(id) FROM ranking.empresa", Integer.class);
    }

    @Override
    public int save(Empresa empresa) {
        return jdbcTemplate.update(
                "insert into empresa (nome, ano) values(?,?)",
                empresa.getNome(), empresa.getAno());
    }

    @Override
    public int update(Empresa empresa) {
        return jdbcTemplate.update(
                "update empresa set nome = ? , ano = ? where id = ?",
                empresa.getNome(),empresa.getAno());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(
	                "delete from empresa where id = ?",
	                id);
    }

    @Override
    public List<Empresa> findAll() {
        return jdbcTemplate.query(
	                "select * from empresa",
	                (rs, rowNum) ->
	                        new Empresa(
	                                rs.getInt("id"),
	                                rs.getString("nome"),
	                                rs.getString("ano")
	                        )
	        );
    }

    @Override
    public Empresa findById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from empresa where id = ?",
                    new Object[]{id},
                    (rs, rowNum) ->
                            new Empresa(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("ano")
                    )
        );
    }

    @Override
    public List<Empresa> findByNome(String nome) {
        return jdbcTemplate.query(
                "select * from empresa where nome Like ?",
                new Object[]{nome},
                (rs, rowNum) ->
                	new Empresa(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("ano")
                )
        );
    }
    
}
