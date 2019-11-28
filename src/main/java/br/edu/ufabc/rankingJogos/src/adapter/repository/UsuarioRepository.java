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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Usuario usuario) {
		byte[] encode = Base64.getEncoder().encode(usuario.getSenha().getBytes());
		String senha = new String(encode);
		
		return jdbcTemplate.update(
                "insert into user (nome, email, senha) values(?,?,?)",
                usuario.getNome(),usuario.getEmail(),senha);
		
	}

	@Override
	public int update(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return null;
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
                                rs.getString("senha")
                                )
        );
	}

}
