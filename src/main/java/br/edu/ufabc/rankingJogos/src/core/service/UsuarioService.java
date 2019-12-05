package br.edu.ufabc.rankingJogos.src.core.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.rankingJogos.src.core.model.UserToken;
import br.edu.ufabc.rankingJogos.src.core.model.Usuario;
import br.edu.ufabc.rankingJogos.src.core.port.repository.UsuarioRepositoryPort;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepositoryPort usuarioRespository;
	@Autowired
	TokenService token;

	
	public int create(Usuario usuario) {
		int res;
		res = usuarioRespository.save(usuario);
		return res;
	}
	
	
	public UserToken login(Usuario usuario) {
		Usuario[] user = new Usuario[1];
		user = usuarioRespository.findByEmail(usuario.getEmail()).toArray(user);
		byte[] encode = Base64.getEncoder().encode(usuario.getSenha().getBytes());
		String senha = new String(encode);
		if(user[0].getSenha().equals(senha)) {
			UserToken token = this.token.geraToken(user[0]);
			return token;
		}
		return null;
		
	}

}
