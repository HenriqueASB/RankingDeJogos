package br.edu.ufabc.rankingJogos.src.core.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufabc.rankingJogos.src.core.model.UserToken;
import br.edu.ufabc.rankingJogos.src.core.model.Usuario;
import br.edu.ufabc.rankingJogos.src.core.port.repository.UsuarioRepositoryPort;
import java.util.List;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepositoryPort usuarioRepository;
	@Autowired
	TokenService token;

	
	public int create(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	public UserToken login(Usuario usuario) {
		Usuario[] user = new Usuario[1];
		user = usuarioRepository.findByEmail(usuario.getEmail()).toArray(user);
		byte[] encode = Base64.getEncoder().encode(usuario.getSenha().getBytes());
		String senha = new String(encode);
		if(user[0].getSenha().equals(senha)) {
			UserToken token = this.token.geraToken(user[0]);
			return token;
		}
		return null;
		
	}
        
        public int update(Usuario usuario) {
            return usuarioRepository.update(usuario);
        }
        
        public int delete(Long id) {
            return usuarioRepository.deleteById(id);
        }
        
        public List<Usuario> readAll() {
            return usuarioRepository.findAll();
        }
        
        public Usuario readById(Long id) {
            return usuarioRepository.findById(id);
        }
        
        public List<Usuario> readByEmail(String email) {
            return usuarioRepository.findByEmail(email);
        }

}
