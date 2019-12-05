package br.edu.ufabc.rankingJogos.src.adapter.repository;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import br.edu.ufabc.rankingJogos.src.core.model.Usuario;
import br.edu.ufabc.rankingJogos.src.core.port.repository.UsuarioRepositoryPort;

@Service
public class UsuarioRepository implements UsuarioRepositoryPort {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {
		return jdbcTemplate.queryForObject("SELECT count(id) FROM ranking.user", Integer.class);
	}

	@Override
	public int save(Usuario usuario) {
		byte[] encode = Base64.getEncoder().encode(usuario.getSenha().getBytes());
		String senha = new String(encode);
		
		return jdbcTemplate.update(
                "insert into user (nome, email, senha, urlFoto) values(?,?,?,?)",
                usuario.getNome(),usuario.getEmail(),senha, usuario.getUrlFoto());
		
	}

	@Override
	public int update(Usuario usuario) {
            return jdbcTemplate.update(
            "update user set nome = ? , email = ? , senha = ? , urlFoto = ? where id = ?",
            usuario.getNome(), usuario.getEmail(),usuario.getSenha(),usuario.getUrlFoto(), usuario.getId());
	}

	@Override
	public int deleteById(Long id) {
            return jdbcTemplate.update(
                "delete from jogo where id = ?",
                id);
	}

	@Override
	public List<Usuario> findAll() {
		return jdbcTemplate.query(
	                "select * from user",
	                (rs, rowNum) ->
	                        new Usuario(
                                    rs.getInt("id"),
                                    rs.getString("nome"),
                                    rs.getString("email"),
                                    rs.getString("senha"),
                                    rs.getString("urlFoto")
	                        )
	        );
	}

	@Override
	public Usuario findById(Long id) {
		return jdbcTemplate.queryForObject(
                "select * from user where id = ?",
                    new Object[]{id},
                    (rs, rowNum) ->
                            new Usuario(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("email"),
                                rs.getString("senha"),
                                rs.getString("urlFoto")
                    )
        );
	}

	@Override
	public List<Usuario> findByEmail(String email) {
		return jdbcTemplate.query(
                "select * from user where email= ?",
                new Object[]{email},
                (rs, rowNum) ->
                        new Usuario(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("email"),
                                rs.getString("senha"),
                                rs.getString("urlFoto")
                                )
        );
	}

}
